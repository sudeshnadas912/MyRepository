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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Allianz.InsuranceProductService.util.MakeServiceCalls;

@Service
public class APLApiService {

	@Value("${apl.base.url}")
	private String aplBaseUrl;
	
	@Value("${apl.getPackagesUrl}")
	private String aplGetAllPackagesUrl;
	
	@Value("${apl.productInstancePostfix}")
	private String aplProductInstancePostfix;
	
	@Autowired
	private MakeServiceCalls makeServiceCalls;
	
	private static final Logger logger = Logger.getLogger( APLApiService.class.getName() );
	
	
	public List<String> getAllPackageNames()
	{
		Client client = ClientBuilder.newClient();
		return getAllPackageNamesFromResponse((makeServiceCalls.makeGetCall(client.target(aplBaseUrl
				+ aplGetAllPackagesUrl)))
				.readEntity(String.class));
	}
	
	private List<String> getAllPackageNamesFromResponse(String response) {

		List<String> packageNames= new ArrayList<String>();
		try {
			JSONObject json = new JSONObject(response);
			JSONArray resultArray = json.getJSONArray("result");
			for (int i = 0; i < resultArray.length(); i++) {
				
				JSONObject passionObject = resultArray.getJSONObject(i);
				packageNames.add(passionObject.getString("caption"));
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return packageNames;

	}
	
	public String createProductInstance() throws JSONException {

		JSONObject jSONObject = new JSONObject("{ \"prodref\":\"A.Product.PO.GDF.PassionPass\"}");
		return makeServiceCalls.makeHttpRestCall(jSONObject, aplBaseUrl +aplProductInstancePostfix, false, HttpMethod.POST);
				

	}
}
