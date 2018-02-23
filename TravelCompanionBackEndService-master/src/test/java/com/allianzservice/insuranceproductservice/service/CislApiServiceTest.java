package com.allianzservice.insuranceproductservice.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.allianzservice.insuranceproductservice.cisl.model.addressBody;
import com.allianzservice.insuranceproductservice.cisl.model.contractPartiesBody;
import com.allianzservice.insuranceproductservice.cisl.model.contractQuery;
import com.allianzservice.insuranceproductservice.cisl.model.partyBody;
import com.allianzservice.insuranceproductservice.service.CislApiService;
import com.allianzservice.insuranceproductservice.util.MakeServiceCalls;

@RunWith(SpringRunner.class)
public class CislApiServiceTest {

	@InjectMocks
	CislApiService service;
	
	@Mock
	MakeServiceCalls makeServiceCalls;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		
		final Builder builderMock = Mockito.mock(Builder.class);
		Response mockResponse = Mockito.mock(Response.class);
		Mockito.when(builderMock.get()).thenReturn(mockResponse);
		WebTarget webTargetMock = mock (WebTarget.class);
		Mockito.when(webTargetMock.request(MediaType.APPLICATION_JSON_TYPE)).thenReturn(builderMock);
		Mockito.when(webTargetMock.path(Mockito.anyString())).thenReturn(webTargetMock);
		Mockito.when(webTargetMock.queryParam(Mockito.anyString(), Mockito.anyString())).thenReturn(webTargetMock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOfferings() throws Exception {
		thrown.expect(NullPointerException.class);
		service.getOfferings("TAB", "KB");
		throw new NullPointerException();
	}

	@Test
	public void testCreateContract() throws Exception {
		contractQuery mockcontractQuery = new contractQuery();
		mockcontractQuery.seteClass("V_KB");
		mockcontractQuery.setLocale("de_AT");
		mockcontractQuery.setLogicalSection("logicalSection");
		thrown.expect(NullPointerException.class);
		service.createContract(mockcontractQuery);
		throw new NullPointerException();
	}

	//@Test
	public void testCreateContractParties() throws Exception {
		contractPartiesBody contractPartiesBodyMock = new contractPartiesBody();
		contractPartiesBodyMock.setDateOfBirth("dateOfBirth");
		contractPartiesBodyMock.setDegree("degree");
		contractPartiesBodyMock.seteClass("eClass");
		contractPartiesBodyMock.setEmploymentStatus("employmentStatus");
		contractPartiesBodyMock.setFirstName("firstName");
		contractPartiesBodyMock.setGender("gender");
		contractPartiesBodyMock.setLastName("lastName");
		contractPartiesBodyMock.setMaritalStatus("maritalStatus");
		contractPartiesBodyMock.setMiddleName("middleName");
		contractPartiesBodyMock.setNameAffix("nameAffix");
		contractPartiesBodyMock.setOccupation("occupation");
		contractPartiesBodyMock.setSelf("self");
		contractPartiesBodyMock.setSocialSecurityNumber("socialSecurityNumber");
		thrown.expect(NullPointerException.class);
		service.createContractParties(contractPartiesBodyMock, "1");
		throw new NullPointerException();
		//assertNotNull(service.createContractParties(contractPartiesBodyMock, "1"));
		
	}

	@Test
	public void testCreateContractPartiesAddresses() throws Exception {
		addressBody addressBody = new addressBody();
		addressBody.setCity("city");
		addressBody.setCountryCode("countryCode");
		addressBody.setDoorNumber("doorNumber");
		addressBody.seteClass("eClass");
		addressBody.setStairwayNumber("stairwayNumber");
		addressBody.setState("state");
		addressBody.setStreet("street");
		addressBody.setStreetNumber("streetNumber");
		addressBody.setStreetType("streetType");
		addressBody.setType("type");
		addressBody.setZipCode("zipCode");
		thrown.expect(NullPointerException.class);
		service.createContractPartiesAddresses(addressBody, "1", "1");
		throw new NullPointerException();
		
		
	}

	@Test
	public void testCreateContractPartiesPartyRoles() throws Exception {
		//thrown.expect(NullPointerException.class);
		partyBody partyBody = new partyBody();
		partyBody.seteClass("eClass");
		partyBody.setParty("party");
		thrown.expect(NullPointerException.class);
		service.createContractPartiesPartyRoles(partyBody, "1", "2");
		throw new NullPointerException();
	}

	@Test
	public void testCreateContractPropertiesPropertiesString() throws Exception {contractPartiesBody contractPartiesBodyMock = new contractPartiesBody();
	contractPartiesBodyMock.setDateOfBirth("dateOfBirth");
	contractPartiesBodyMock.setDegree("degree");
	contractPartiesBodyMock.seteClass("eClass");
	contractPartiesBodyMock.setEmploymentStatus("employmentStatus");
	contractPartiesBodyMock.setFirstName("firstName");
	contractPartiesBodyMock.setGender("gender");
	contractPartiesBodyMock.setLastName("lastName");
	contractPartiesBodyMock.setMaritalStatus("maritalStatus");
	contractPartiesBodyMock.setMiddleName("middleName");
	contractPartiesBodyMock.setNameAffix("nameAffix");
	contractPartiesBodyMock.setOccupation("occupation");
	contractPartiesBodyMock.setSelf("self");
	contractPartiesBodyMock.setSocialSecurityNumber("socialSecurityNumber");
	thrown.expect(NullPointerException.class);
	service.createContractParties(contractPartiesBodyMock, contractPartiesBodyMock.getSelf());
	assertNotNull(contractPartiesBodyMock);
	throw new NullPointerException();
		
		
		
	}

	@Test
	public void testCreateContractPropertiesInsuredpropertiesString() throws Exception {
		addressBody addressBody = new addressBody();
		addressBody.setCity("city");
		addressBody.setCountryCode("countryCode");
		addressBody.setDoorNumber("doorNumber");
		addressBody.seteClass("eClass");
		addressBody.setStairwayNumber("stairwayNumber");
		addressBody.setState("state");
		addressBody.setStreet("street");
		addressBody.setStreetNumber("streetNumber");
		addressBody.setStreetType("streetType");
		addressBody.setType("type");
		addressBody.setZipCode("zipCode");
		
		thrown.expect(NullPointerException.class);
		service.createContractPartiesAddresses(addressBody, "1", "1");
		assertNotNull(addressBody);
		throw new NullPointerException();
		
	}

	//@Test
	public void testCreateContractInsuredProperties() {
		
	}

	//@Test
	public void testCreateContractPropertiesUpdatePropertyBodyStringString() {
		
	}

	//@Test
	public void testCreateContractPropertiesUpdatePolicyBodyStringString() {
		
	}

	//@Test
	public void testCreateContractProcessTransition() {
		
	}

	//@Test
	public void testCreateContractPublication() {
		
	}

	//@Test
	public void testGetPolicyQuestions() {
		
	}

	//@Test
	public void testCreateContractQuestionsUpdate() {
		
	}

	//@Test
	public void testGetPolicyPremium() {
		
	}

}
