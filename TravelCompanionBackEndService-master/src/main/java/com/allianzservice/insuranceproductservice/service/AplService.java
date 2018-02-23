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
package com.allianzservice.insuranceproductservice.service;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.allianzservice.insuranceproductservice.util.MakeServiceCalls;

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

}
