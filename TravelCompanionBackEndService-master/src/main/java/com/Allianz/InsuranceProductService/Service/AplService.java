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

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Allianz.InsuranceProductService.util.MakeServiceCalls;

/**
 * 
 * @author qkg7e9r
 * Service to call APL
 *
 */

@Service
public class AplService {
	
	
	
	@Autowired
	private MakeServiceCalls makeServiceCalls;
	
	@Value("${apl.base.url}")
	private String aplBaseUrl;
	
	
	
	public String getAllExistingPassion() throws JSONException {
		Client client = ClientBuilder.newClient();
		return (makeServiceCalls.makeGetCall(client.target(aplBaseUrl
				+ "/catalog;model=GDF/componentdefinition;uname=%3EA.Product.BO.GDF.Passion")))
						.readEntity(String.class);

	}
	
	public String createProductInstance() throws JSONException {

		JSONObject jSONObject = new JSONObject("{ \"prodref\":\"A.Product.PO.GDF.PassionPass\"}");
		return makeServiceCalls.makeHttpRestCall(jSONObject, aplBaseUrl + "/config;model=GDF", false, HttpMethod.POST);
				

	}



	public String getPassionSelector(String passionPass, String passionSelecktor) throws JSONException {
		Client client = ClientBuilder.newClient();
		return (makeServiceCalls.makeGetCall(client.target(aplBaseUrl
				+ "/config;model=GDF;id=" + passionPass + "/component;id=" + passionSelecktor)))
						.readEntity(String.class);

	}

	public String fetchComponentsFromSelector(String url,String packageName) throws JSONException {
		JSONObject jsonObject = new JSONObject("{ \"prodref\":\"A.Product.PO.GDF."+packageName+"Selektor\"}");
		return makeServiceCalls.makeHttpRestCall(jsonObject, url, false, HttpMethod.POST);
				

	}
//
//	public String getAllPackages(String passionPass) throws JSONException {
//		return (makeServiceCalls.makeGetCall(
//				client.target(aplBaseUrl+ "/config;model=GDF;id=" + passionPass)))
//						.readEntity(String.class);
//
//	}
//
//	
//	
//	public List<Passion> getAllPassions(String passionStr) {
//
//		List<Passion> passionList = new ArrayList<Passion>();
//		try {
//			JSONObject json = new JSONObject(passionStr);
//			JSONArray resultArray = json.getJSONArray("result");
//			for (int i = 0; i < resultArray.length(); i++) {
//				Passion passion = new Passion();
//				JSONObject passionObject = resultArray.getJSONObject(i);
//				passion.setUname(passionObject.getString("uname"));
//				passion.setCaption(passionObject.getString("caption"));
//				passion.setAreaDescrs(passionObject.getString("areaDescrs"));
//				passion.setAttrDescrs(passionObject.getString("attrDescrs"));
//				passion.setFields(passionObject.getString("fields"));
//				passionList.add(passion);
//			}
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return passionList;
//
//	}
//
//	public void saveProduct(String response) {
//		Product product = ProductMapUtil.productMapping(response);
//		// product.save();
//	}
//
//	public Product getProductComponent(String component, String passionUrl) {
//
//		String componentRef = null;
//		Product product = ProductMapUtil.productMapping(passionUrl);
//		List<Area> areaList = product.getAreaList();
//		for (Area area : areaList) {
//			List<CompRefs> compRefsList = area.getCompRefsList();
//			for (CompRefs refs : compRefsList) {
//				if (refs.getName().equalsIgnoreCase(component)) {
//					componentRef = refs.getRef();
//				}
//			}
//		}
//		System.out.println("componentRef" + componentRef);
//
//		Client client = ClientBuilder.newClient();
//		String compResponse = makeServiceCalls.makeGetCall(client.target(componentRef)).readEntity(String.class);
//		Product productComponent = ProductMapUtil.productMapping(compResponse);
//		return productComponent;
//
//	}
//	
//	public Product getComponetByProductComponentId(String passionPass, String passionSelecktor){
//		String response = null;
//		try {
//			response = getPassionSelector(passionPass, passionSelecktor);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ProductMapUtil.productMapping(response);
//	}
//	
//	
//
}
