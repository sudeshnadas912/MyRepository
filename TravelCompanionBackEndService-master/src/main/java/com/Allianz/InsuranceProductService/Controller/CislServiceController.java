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
package com.Allianz.InsuranceProductService.Controller;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Allianz.InsuranceProductService.cisl.Model.addressBody;
import com.Allianz.InsuranceProductService.cisl.Model.contract;
import com.Allianz.InsuranceProductService.cisl.Model.contractPartiesBody;
import com.Allianz.InsuranceProductService.cisl.Model.contractQuery;
import com.Allianz.InsuranceProductService.cisl.Model.insuredproperties;
import com.Allianz.InsuranceProductService.cisl.Model.partyBody;
import com.Allianz.InsuranceProductService.cisl.Model.policyBody;
import com.Allianz.InsuranceProductService.cisl.Model.processtransition;
import com.Allianz.InsuranceProductService.cisl.Model.properties;
import com.Allianz.InsuranceProductService.cisl.Model.propertyBody;
import com.Allianz.InsuranceProductService.cisl.Model.questionBody;
import com.Allianz.InsuranceProductService.util.MakeCislCall;
import com.Allianz.InsuranceProductService.util.MakeServiceCalls;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cisl")
@Api(value = "Cisl Service Calls", description = "To interact with CISL services")
public class CislServiceController {

	private static final String CONTRACTS = "/contracts/";
	private static final String POLICIES = "/policies/";

	@Value("${cisl.policy.search.url}")
	private String cislPolicyUrl;

	@Value("${cisl.base.url}")
	private String cislBaseUri;

	@Value("${cisl.parties.search.url}")
	private String cislPartiesUrl;

	@Value("${cisl.claim.classes.url}")
	private String claimClassesUrl;

	@Value("${cisl.file.claim.url}")
	private String fileClaimUrl;

	@Autowired
	private MakeCislCall makeCislCall;

	@Autowired
	private MakeServiceCalls makeServiceCalls;

	private static final Logger LOGGER = Logger.getLogger(CislServiceController.class.getName());

	// Motor Buy Journey
	// GET /offerings
	@ApiOperation("To get all the offerings")
	@GetMapping("offerings/salesChannel/{salesChannel}/lineOfBusiness/{lineOfBusiness}")
	public String getOfferings(@PathVariable String salesChannel, @PathVariable String lineOfBusiness)
			throws JSONException {
		Client client = ClientBuilder.newClient();
		return (makeServiceCalls.makeGetCall(client
				.target(cislBaseUri + "/offerings?salesChannel=" + salesChannel + "&lineOfBusiness=" + lineOfBusiness)))
						.readEntity(String.class);

	}

	@ApiOperation("To create the contract")
	@PostMapping("/contracts")
	public String createContract(@RequestBody contractQuery contractQuery) throws JSONException {
		contract jsonResponse = null;
		HttpResponse<String> jsonString = null;

		LOGGER.info("eclass-->" + contractQuery.geteClass());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("locale", contractQuery.getLogicalSection());
		jsonObject.put("eClass", contractQuery.geteClass());
		jsonObject.put("logicalSection", contractQuery.getLogicalSection());

		return makeServiceCalls.makeHttpRestCall(jsonObject, cislBaseUri + "/contracts", true, HttpMethod.POST);

	}

	@ApiOperation("To push party details for the created contract")
	@PostMapping("/contracts/{contractId}/parties")
	public String createContractParties(@RequestBody contractPartiesBody contractPartiesBody,
			@PathVariable String contractId) throws JSONException {
		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(contractPartiesBody),
				cislBaseUri + CONTRACTS + contractId + "/parties", true, HttpMethod.POST);

	}

	@ApiOperation("To push address information of the party for a particular signed contract")
	@PostMapping("/contracts/{contractId}/parties/{partyId}/addresses")
	public String createContractPartiesAddresses(@RequestBody addressBody addressBody, @PathVariable String contractId,
			@PathVariable String partyId) throws JSONException {
		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(addressBody),
				cislBaseUri + CONTRACTS + contractId + "/parties/" + partyId + "/addresses?logicalSection=V_KB", true,
				HttpMethod.POST);

	}

	@ApiOperation("To assign party role for the parties in the contract")
	@PostMapping("/contracts/{contractId}/parties/{partyId}/partyroles")
	public String createContractPartiesPartyRoles(@RequestBody partyBody partyBody, @PathVariable String contractId,
			@PathVariable String partyId) throws JSONException {
		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(partyBody),
				cislBaseUri + CONTRACTS + contractId + "/parties/" + partyId + "/partyroles?logicalSection=V_KB", true,
				HttpMethod.POST);

	}

	// test from here
	@ApiOperation("To provide information regarding properties of the object which is insured")
	@PostMapping("/contracts/{contractId}/properties")
	public String createContractProperties(@RequestBody properties properties, @PathVariable String contractId)
			throws JSONException {
		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(properties),
				cislBaseUri + CONTRACTS + contractId + "/properties", true, HttpMethod.POST);

	}

	@ApiOperation("To create insured properties")
	@PostMapping("/contracts/{contractId}/insuredproperties")
	public String createContractProperties(@RequestBody insuredproperties insuredproperties,
			@PathVariable String contractId) throws JSONException {
		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(insuredproperties),
				cislBaseUri + CONTRACTS + contractId + "/insuredproperties", true, HttpMethod.POST);

	}

	@ApiOperation("To create the policy")
	@PostMapping("/contracts/{contractId}/policies/{link}")
	public String createContractInsuredProperties(@PathVariable String link, @PathVariable String contractId)
			throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("link", link);
		return makeServiceCalls.makeHttpRestCall(jsonObject, cislBaseUri + CONTRACTS + contractId + "/policies", true,
				HttpMethod.POST);

	}

	@ApiOperation("To update property details")
	@PutMapping("/contracts/{contractId}/properties/{propertiesId}")
	public String createContractPropertiesUpdate(@RequestBody propertyBody propertyBody,
			@PathVariable String propertiesId, @PathVariable String contractId) throws JSONException {

		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(propertyBody),
				cislBaseUri + CONTRACTS + contractId + "/properties/" + propertiesId, true, HttpMethod.PUT);

	}

	@ApiOperation("To update policy details")
	@PutMapping("/contracts/{contractId}/policies/{policyId}")
	public String createContractPropertiesUpdate(@RequestBody policyBody policyBody, @PathVariable String policyId,
			@PathVariable String contractId) throws JSONException {

		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(policyBody),
				cislBaseUri + CONTRACTS + contractId + POLICIES + policyId, true, HttpMethod.PUT);

	}

	@ApiOperation("To procces the policy to next stage")
	@PostMapping("/contracts/{contractId}/processtransition")
	public String createContractProcessTransition(@RequestBody processtransition processtransition,
			@PathVariable String contractId) throws JSONException {

		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(processtransition),
				cislBaseUri + CONTRACTS + contractId + "/processtransition", true, HttpMethod.POST);

	}

	@ApiOperation("For policy Number Generation")
	@PostMapping("/contracts/{contractId}/publication/{policyNumberGeneration}")
	public String createContractPublication(@RequestBody processtransition processtransition,
			@PathVariable String contractId, @PathVariable String policyNumberGeneration) throws JSONException {

		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(processtransition),
				cislBaseUri + CONTRACTS + contractId + "/publication?policyNumberGeneration=" + policyNumberGeneration,
				true, HttpMethod.POST);

	}

	@ApiOperation("To get all the question asked regarding the generated policy")
	@GetMapping("contracts/{contractId}/policies/{policyId}/questions")
	public String getPolicyQuestions(@PathVariable String contractId, @PathVariable String policyId)
			throws JSONException {
		Client client = ClientBuilder.newClient();
		return (makeServiceCalls
				.makeGetCall(client.target(cislBaseUri + CONTRACTS + contractId + POLICIES + policyId + "/questions")))
						.readEntity(String.class);

	}

	@ApiOperation("To update the question based on question Id")
	@PutMapping("/contracts/{contractId}/policies/{policyId}/questions/{questionId}")
	public String createContractQuestionsUpdate(@RequestBody questionBody questionBody, @PathVariable String policyId,
			@PathVariable String contractId, @PathVariable String questionId) throws JSONException {

		return makeServiceCalls.makeHttpRestCall(convertObjectToJSON(questionBody),
				cislBaseUri + CONTRACTS + contractId + POLICIES + policyId + "/questions/" + questionId, true,
				HttpMethod.PUT);

	}

	@ApiOperation("To get premium details of the policy")
	@GetMapping("contracts/{contractId}/policies/{policyId}/premium")
	public String getPolicyPremium(@PathVariable String contractId, @PathVariable String policyId)
			throws JSONException {
		Client client = ClientBuilder.newClient();
		return (makeServiceCalls
				.makeGetCall(client.target(cislBaseUri + CONTRACTS + contractId + POLICIES + policyId + "/premium")))
						.readEntity(String.class);

	}

	private JSONObject convertObjectToJSON(Object obj) throws JSONException {
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(obj);
		return new JSONObject(json);
	}

}
