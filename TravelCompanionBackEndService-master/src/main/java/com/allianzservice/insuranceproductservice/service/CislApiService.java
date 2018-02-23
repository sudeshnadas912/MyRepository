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

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.allianzservice.insuranceproductservice.cisl.model.addressBody;
import com.allianzservice.insuranceproductservice.cisl.model.contract;
import com.allianzservice.insuranceproductservice.cisl.model.contractPartiesBody;
import com.allianzservice.insuranceproductservice.cisl.model.contractQuery;
import com.allianzservice.insuranceproductservice.cisl.model.insuredproperties;
import com.allianzservice.insuranceproductservice.cisl.model.partyBody;
import com.allianzservice.insuranceproductservice.cisl.model.policyBody;
import com.allianzservice.insuranceproductservice.cisl.model.processtransition;
import com.allianzservice.insuranceproductservice.cisl.model.properties;
import com.allianzservice.insuranceproductservice.cisl.model.propertyBody;
import com.allianzservice.insuranceproductservice.cisl.model.questionBody;
import com.allianzservice.insuranceproductservice.util.MakeServiceCalls;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
@Service
public class CislApiService {
	
	private static final String CONTRACTS = "/contracts/";
	private static final String POLICIES = "/policies/";
	
	@Value("${cisl.base.url}")
	private String cislBaseUri;
	
	@Autowired
	private MakeServiceCalls makeServiceCalls;
	
	private static final Logger logger = Logger.getLogger( CislApiService.class.getName() );

	
	//Motor Buy Journey
	public String getOfferings( String salesChannel, String lineOfBusiness) throws JSONException
	{
		Client client = ClientBuilder.newClient();
		return (makeServiceCalls.makeGetCall(client.target(cislBaseUri+"/offerings?salesChannel="+salesChannel+"&lineOfBusiness="+lineOfBusiness))).readEntity(String.class);
		
	}

	
	public String createContract( contractQuery contractQuery) throws JSONException
	{
		contract jsonResponse=null;
		HttpResponse<String> jsonString=null;
		
		
		
		logger.info("eclass-->"+contractQuery.geteClass());
		JSONObject jsonObject= new JSONObject();
		jsonObject.put("locale", contractQuery.getLogicalSection());
		jsonObject.put("eClass",contractQuery.geteClass());
		jsonObject.put("logicalSection", contractQuery.getLogicalSection());
		
		
		
		return makeServiceCalls.makeHttpRestCall(jsonObject, cislBaseUri+"/contracts", true, HttpMethod.POST);
				
		
	}

	
	public String createContractParties( contractPartiesBody contractPartiesBody, String contractId) throws JSONException
	{
		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(contractPartiesBody), cislBaseUri+CONTRACTS+contractId+"/parties", true, HttpMethod.POST);
				
		
	}

	
	public String createContractPartiesAddresses( addressBody addressBody, String contractId, String partyId) throws JSONException
	{
		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(addressBody), cislBaseUri+CONTRACTS+contractId+"/parties/"+partyId+"/addresses?logicalSection=V_KB", true, HttpMethod.POST);
				
		
	}

	
	public String createContractPartiesPartyRoles( partyBody partyBody, String contractId, String partyId) throws JSONException
	{
		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(partyBody), cislBaseUri+CONTRACTS+contractId+"/parties/"+partyId+"/partyroles?logicalSection=V_KB", true, HttpMethod.POST);
		
		
	}
	
	
	public String createContractProperties( properties properties, String contractId) throws JSONException
	{
		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(properties), cislBaseUri+CONTRACTS+contractId+"/properties", true, HttpMethod.POST);
	
		
	}

	
	public String createContractProperties( insuredproperties insuredproperties, String contractId) throws JSONException
	{
		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(insuredproperties), cislBaseUri+CONTRACTS+contractId+"/insuredproperties", true, HttpMethod.POST);
		
		
	}

	
	public String createContractInsuredProperties( String link, String contractId) throws JSONException
	{
		JSONObject jsonObject= new JSONObject();
		jsonObject.put("link", link);
		return makeServiceCalls.makeHttpRestCall(jsonObject, cislBaseUri+CONTRACTS+contractId+"/policies", true, HttpMethod.POST);
	
		
	}

	
	public String createContractPropertiesUpdate( propertyBody propertyBody,  String propertiesId, String contractId) throws JSONException
	{
		
		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(propertyBody), cislBaseUri+CONTRACTS+contractId+"/properties/"+propertiesId, true, HttpMethod.PUT);
			
				
		
	}

	
	public String createContractPropertiesUpdate( policyBody policyBody,  String policyId, String contractId) throws JSONException
	{
		
		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(policyBody), cislBaseUri+CONTRACTS+contractId+POLICIES+policyId, true, HttpMethod.PUT);
		
				
		
	}

	public String createContractProcessTransition( processtransition processtransition,  String contractId) throws JSONException
	{
		
		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(processtransition), cislBaseUri+CONTRACTS+contractId+"/processtransition", true, HttpMethod.POST);
				
				
		
	}

	public String createContractPublication( processtransition processtransition,  String contractId, String policyNumberGeneration) throws JSONException
	{
		
		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(processtransition), cislBaseUri+CONTRACTS+contractId+"/publication?policyNumberGeneration="+policyNumberGeneration, true, HttpMethod.POST);
				
		
	}
	
	public String getPolicyQuestions( String contractId, String policyId) throws JSONException
	{
		Client client = ClientBuilder.newClient();
		return (makeServiceCalls.makeGetCall(client.target(cislBaseUri+CONTRACTS+contractId+POLICIES+policyId+"/questions"))).readEntity(String.class);
		
	}

	
	public String createContractQuestionsUpdate( questionBody questionBody,  String policyId, String contractId, String questionId) throws JSONException
	{
		
		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(questionBody), cislBaseUri+CONTRACTS+contractId+POLICIES+policyId+"/questions/"+questionId, true, HttpMethod.PUT);
				
				
		
	}

	
	public String getPolicyPremium( String contractId, String policyId) throws JSONException
	{
		Client client = ClientBuilder.newClient();
		return (makeServiceCalls.makeGetCall(client.target(cislBaseUri+CONTRACTS+contractId+POLICIES+policyId+"/premium"))).readEntity(String.class);
		
	}


	private JSONObject convertObjectToJSON(Object obj) throws JSONException
	{
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(obj);
		return new JSONObject(json);
	}



}
