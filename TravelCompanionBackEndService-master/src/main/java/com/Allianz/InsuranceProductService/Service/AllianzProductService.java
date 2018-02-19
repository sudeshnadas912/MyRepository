/*******************************************************************************
 * Copyright 2018 TCS
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.Allianz.InsuranceProductService.Service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Allianz.InsuranceProductService.Controller.TravelCompanionBackendController;
import com.Allianz.InsuranceProductService.Model.PackageinfoVO;
import com.Allianz.InsuranceProductService.Model.ProductInfoVO;
import com.Allianz.InsuranceProductService.Model.User;
import com.Allianz.InsuranceProductService.cisl.Model.Area;
import com.Allianz.InsuranceProductService.cisl.Model.CompRefs;
import com.Allianz.InsuranceProductService.cisl.Model.ProductInstance;
import com.Allianz.InsuranceProductService.cisl.Model.contract;
import com.Allianz.InsuranceProductService.cisl.Model.contractPartiesBody;
import com.Allianz.InsuranceProductService.cisl.Model.contractPartiesSearch;
import com.Allianz.InsuranceProductService.cisl.Model.contractQuery;
import com.Allianz.InsuranceProductService.util.DataMocker;
import com.Allianz.InsuranceProductService.util.MakeServiceCalls;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@Service
public class AllianzProductService {
	

	@Autowired
	private MakeServiceCalls makeServiceCalls;

	@Autowired
	private ProductInfoVO productInfoVO;

	
	@Autowired
	private CislApiService cislApiService;

	@Autowired
	private DataMocker dataMocker;

	@Autowired
	private APLApiService aplService;

	private static final Logger logger = Logger.getLogger(TravelCompanionBackendController.class.getName());

	// To get the Product structure from APL
	public ProductInfoVO getProductInfo(String productName) throws JsonSyntaxException, JSONException {
		Client client = ClientBuilder.newClient();
		// Set the product name for the ProductVO
		productInfoVO.setProductName(productName);

		// Fetch all the packages offered by the product
		logger.info("fetch all the package Names");
		List<String> packageNames = aplService.getAllPackageNames();
		packageNames.forEach(names -> System.out.println("names-->" + names));

		// create a product instance
		logger.info("Create a product instance");
		ProductInstance productInstance = new Gson().fromJson(aplService.createProductInstance(),
				ProductInstance.class);
		logger.info("result Object-->" + productInstance.getResult().getCaption());

		// fetch selectors url from response
		logger.info("Fetch all the selector in the product ");
		Area[] areaList = productInstance.getResult().getAreas();
		String selectorUrl = "";
		for (Area area : areaList) {
			System.out.println("area Name-->" + area.getName());
			if (area.getName().contains("Selektors")) {
				logger.info("list of compref count-->" + area.getCompRefsList().size());
				List<CompRefs> compRefList = area.getCompRefsList();
				for (CompRefs compRefs : compRefList) {
					logger.info("compRef name-->" + compRefs.getName());
					if (compRefs.getName().contains("Selector")) {
						selectorUrl = compRefs.getRef();
					}
				}
			}
		}

		// Making a get call for selector url to get all the selectors available
		logger.info("making get call to selector url-->"
				+ makeServiceCalls.makeGetCall(client.target(selectorUrl)).readEntity(String.class));

		// fetch components of the Package
		logger.info("fetch all the components in the package from its selector Name\n");
		List<PackageinfoVO> packageinfoVOList = new ArrayList<PackageinfoVO>();
		for (String packageName : packageNames) {

			JSONObject jsonObject = new JSONObject("{ \"prodref\":\"A.Product.PO.GDF." + packageName + "Selektor\"}");
			ProductInstance components = new Gson().fromJson(
					makeServiceCalls.makeHttpRestCall(jsonObject, selectorUrl, false, HttpMethod.POST),
					ProductInstance.class);
			logger.info("response for " + packageName + " -->"
					+ makeServiceCalls.makeHttpRestCall(jsonObject, selectorUrl, false, HttpMethod.POST));
			PackageinfoVO packageinfoVO = new PackageinfoVO();
			packageinfoVO.setPackageName(packageName);
			List<String> componentDescription = new ArrayList<String>();
			for (Area area : components.getResult().getAreas()) {
				if (!area.getName().contains("Passion")) {

					componentDescription.add(area.getCaption());
				}
			}
			packageinfoVO.setPackageDescription(componentDescription);
			packageinfoVOList.add(packageinfoVO);

		}
		productInfoVO.setPackageList(packageinfoVOList);

		// sproductInfoVO.setPackageList(packageinfoVOList);
		return productInfoVO;
	}

	// To make fetch the contract details and file a policy for that contract
	public boolean fileMobilityInsurance(User user) throws JSONException {
		boolean status = true;
		Gson gson = new Gson();

		// retrieving the contract details.
		contract contract = gson.fromJson(
				cislApiService.createContract((contractQuery) dataMocker.getMockOfObject(new contractQuery())),
				contract.class);

		// retreiving party Details
		contractPartiesSearch contractPartiesSearch = gson.fromJson(
				cislApiService.createContract((contractQuery) dataMocker.getMockOfObject(new contractPartiesBody())),
				contractPartiesSearch.class);

		return status;
	}

}
