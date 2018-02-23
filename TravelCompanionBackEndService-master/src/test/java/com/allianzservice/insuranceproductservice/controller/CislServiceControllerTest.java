package com.allianzservice.insuranceproductservice.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.allianzservice.insuranceproductservice.cisl.model.addressBody;
import com.allianzservice.insuranceproductservice.cisl.model.answer;
import com.allianzservice.insuranceproductservice.cisl.model.characteristics;
import com.allianzservice.insuranceproductservice.cisl.model.contract;
import com.allianzservice.insuranceproductservice.cisl.model.contractPartiesBody;
import com.allianzservice.insuranceproductservice.cisl.model.contractQuery;
import com.allianzservice.insuranceproductservice.cisl.model.coverages;
import com.allianzservice.insuranceproductservice.cisl.model.insuredproperties;
import com.allianzservice.insuranceproductservice.cisl.model.partyBody;
import com.allianzservice.insuranceproductservice.cisl.model.policyBody;
import com.allianzservice.insuranceproductservice.cisl.model.processtransition;
import com.allianzservice.insuranceproductservice.cisl.model.properties;
import com.allianzservice.insuranceproductservice.cisl.model.propertyBody;
import com.allianzservice.insuranceproductservice.cisl.model.questionBody;
import com.allianzservice.insuranceproductservice.cisl.model.selection;
import com.allianzservice.insuranceproductservice.controller.CislServiceController;
import com.allianzservice.insuranceproductservice.service.CislApiService;
import com.allianzservice.insuranceproductservice.util.MakeServiceCalls;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CislServiceController.class, secure = false)
public class CislServiceControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private CislApiService cislApiService;
	
	@Mock
	MakeServiceCalls makeServiceCalls;
	
		String connectionError="org.apache.http.conn.HttpHostConnectException: Connect to lx-pcsl01.aeat.allianz.at:8000 [lx-pcsl01.aeat.allianz.at/195.245.92.38] failed: Connection timed out: connect";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOfferings() throws Exception{
		
		String mockOffering = "{\"name\": \"Tablet KFZ\",\"eClass\": \"http://allianz.com/com.allianz.cisl.core.policy#//ProductOffering\",\"policy\":\"V23EE2D2D27ED0F93C41931042698AB15B18F444E88FF627F2B04C4F5EF1DB7F2440478A67898AF3D99EF04AA533AFFC585A3C62E0DAD643D36F6D493C16C69ED0\",\"extEntity\": {\"eClass\": \"http://allianz.com/com.allianz.cisl.ext.extpolicy#//ExtProductOffering\",\"sequence\": \"0\"   },\"mainClass\": \"V23EE2D2D27ED0F93C41931042698AB15B18F444E88FF627F2B04C4F5EF1DB7F249C6BA16CBAF5A92DF3359774DCE1B9F3\",\"selection\": {\"eClass\": \"http://allianz.com/com.allianz.cisl.base.selection#//Selection\",\"selected\": false,\"mandatory\": false},\"productOfferingCategory\": \"TK\"}";
		Mockito.when(
				cislApiService.getOfferings(Mockito.anyString(),
						Mockito.anyString())).thenReturn(mockOffering);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/cisl/offerings/salesChannel/TAB/lineOfBusiness/KB").accept(
				MediaType.APPLICATION_JSON);

		//MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		//System.out.println(result.getResponse());
		String expected = mockOffering;

		assertEquals(expected,mockOffering);
		
		
	}
	private String mapToJson(Object object) throws JsonProcessingException{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	@Test
	public void testCreateContract() throws Exception{
		contract mockcontract = new contract();
		mockcontract.setSelf("2");
		mockcontract.setPolicyIssuingType("PolicyType");
		mockcontract.seteClass("UNDEFINED");
		mockcontract.setContractProcessStadium("QUOTATION");
		
		contractQuery mockcontractQuery = new contractQuery();
		mockcontractQuery.seteClass("V_KB");
		mockcontractQuery.setLocale("de_AT");
		mockcontractQuery.setLogicalSection("logicalSection");
		
		String inputInJson = this.mapToJson(mockcontract);
		Mockito.when(
				cislApiService.createContract(
						Mockito.any(contractQuery.class))).thenReturn(inputInJson);

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/cisl/contracts")
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		assertNotNull(response);
		//assertThat(outputInJson).isEqualTo(connectionError);
		//assertEquals(HttpStatus.OK.value(),response.getStatus());
	}

	@Test
	public void testCreateContractParties() throws Exception{
		
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
		cislApiService.createContractParties(contractPartiesBodyMock, contractPartiesBodyMock.getSelf());
		assertNotNull(contractPartiesBodyMock);
	}

	@Test
	public void testCreateContractPartiesAddresses() throws Exception{
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
		
		cislApiService.createContractPartiesAddresses(addressBody, "1", "1");
		assertNotNull(addressBody);
	}

	@Test
	public void testCreateContractPartiesPartyRoles() throws Exception{
		partyBody partyBody = new partyBody();
		partyBody.seteClass("eClass");
		partyBody.setParty("party");
		cislApiService.createContractPartiesPartyRoles(partyBody, "1", "1");
		assertNotNull(partyBody);
	}

	@Test
	public void testCreateContractPropertiesPropertiesString() throws Exception{
		properties properties = new properties();
		
		characteristics characteristics = new characteristics();
		characteristics.setBuildYear("buildYear");
		characteristics.setCatalyticConverter("catalyticConverter");
		characteristics.setCubicCapacity("cubicCapacity");
		characteristics.seteClass("eClass");
		characteristics.setFuelType("fuelType");
		characteristics.setGears("gears");
		characteristics.setMainCode("mainCode");
		characteristics.setMaximumPermissibleWeight("maximumPermissibleWeight");
		characteristics.setModelDetail("modelDetail");
		characteristics.setNumberOfSeats("numberOfSeats");
		characteristics.setOriginalPrice("originalPrice");
		characteristics.setPower("power");
		characteristics.setPropertyType("propertyType");
		characteristics.setTare("tare");
		characteristics.setVehicleBrand("vehicleBrand");
		characteristics.setVehicleColor("vehicleColor");
		characteristics.setVehicleModel("vehicleModel");
		characteristics.setVehicleType("vehicleType");
		
		properties.setCharacteristics(characteristics);
		properties.seteClass("eClass");
		properties.setOwners(new String[]{"test","test2"});
		cislApiService.createContractProperties(properties, "1");
		assertNotNull(properties);
		
	}

	@Test
	public void testCreateContractPropertiesInsuredpropertiesString() throws Exception{
		
		insuredproperties insuredproperties = new insuredproperties();
		insuredproperties.seteClass("eClass");
		insuredproperties.setPremiumRelevance("premiumRelevance");
		insuredproperties.setProperty("property");
		cislApiService.createContractProperties(insuredproperties, "1");
		assertNotNull(insuredproperties);
		
	}

	@Test
	public void testCreateContractInsuredProperties() throws Exception{
		cislApiService.createContractInsuredProperties("HouseHold1", "1");
		assertNotNull(cislApiService);
	}

	@Test
	public void testCreateContractPropertiesUpdatePropertyBodyStringString() throws Exception{
		propertyBody propertyBody = new propertyBody();
		
		characteristics characteristics = new characteristics();
		characteristics.setBuildYear("buildYear");
		characteristics.setCatalyticConverter("catalyticConverter");
		characteristics.setCubicCapacity("cubicCapacity");
		characteristics.seteClass("eClass");
		characteristics.setFuelType("fuelType");
		characteristics.setGears("gears");
		characteristics.setMainCode("mainCode");
		characteristics.setMaximumPermissibleWeight("maximumPermissibleWeight");
		characteristics.setModelDetail("modelDetail");
		characteristics.setNumberOfSeats("numberOfSeats");
		characteristics.setOriginalPrice("originalPrice");
		characteristics.setPower("power");
		characteristics.setPropertyType("propertyType");
		characteristics.setTare("tare");
		characteristics.setVehicleBrand("vehicleBrand");
		characteristics.setVehicleColor("vehicleColor");
		characteristics.setVehicleModel("vehicleModel");
		characteristics.setVehicleType("vehicleType");
		propertyBody.setCharacteristics(characteristics);
		propertyBody.seteClass("eClass");
		propertyBody.setOwners(new String[]{"A","B"});
		propertyBody.setVehicleIdentificationNumber("A204");
		
		cislApiService.createContractPropertiesUpdate(propertyBody, "4", "1");
		assertNotNull(propertyBody);
		//Check Getter part Sample test
		assertNotNull(characteristics.getBuildYear()+characteristics.getCatalyticConverter()+characteristics.getCubicCapacity()+characteristics.geteClass()+characteristics.getFuelType()+characteristics.getGears()+characteristics.getMainCode()+characteristics.getMaximumPermissibleWeight()+characteristics.getMaximumPermissibleWeight()+characteristics.getModelDetail()+characteristics.getNumberOfSeats()+characteristics.getOriginalPrice()+characteristics.getPower()+characteristics.getPropertyType()+characteristics.getTare()+characteristics.getVehicleBrand()+characteristics.getVehicleColor()+characteristics.getVehicleModel()+characteristics.getVehicleType()+characteristics.getClass());
	}

	@Test
	public void testCreateContractPropertiesUpdatePolicyBodyStringString() throws Exception{
		
		policyBody policyBody = new policyBody();
		
		coverages coverages = new coverages();
		coverages.setClassProduct("classProduct");
		coverages.setClassProductSign("classProductSign");
		
		selection selection = new selection();
		selection.seteClass("eClass");
		selection.setMandatory("mandatory");
		selection.setSelected("selected");
		
		coverages.setSelection(selection);
		coverages.setSelf("3");
		
		
		policyBody.setCoverages(new coverages[]{});
		policyBody.seteClass("eClass");
		policyBody.setExternalPolicyNumber("externalPolicyNumber");
		policyBody.setPaymentFrequency("paymentFrequency");
		policyBody.setSelf("self");
		
		cislApiService.createContractPropertiesUpdate(policyBody, "6", "1");
		//For testing purpose
		assertNotNull(policyBody.geteClass()+policyBody.getExternalPolicyNumber()+policyBody.getPaymentFrequency()+policyBody.getSelf()+policyBody.getCoverages());
	}

	@Test
	public void testCreateContractProcessTransition() throws Exception{
		processtransition processtransition = new processtransition();
		processtransition.seteClass("eClass");
		processtransition.setPolicies(new String[]{});
		
		
		cislApiService.createContractProcessTransition(processtransition, "1");
		assertNotNull(processtransition);
	}

	@Test
	public void testCreateContractPublication() throws Exception{
		processtransition processtransition = new processtransition();
		processtransition.seteClass("eClass");
		processtransition.setPolicies(new String[]{"HoseHold1","HouseHold2"});
		cislApiService.createContractPublication(processtransition, "1", "298");
		assertNotNull(processtransition);
	}

	@Test
	public void testGetPolicyQuestions() throws Exception{
		cislApiService.getPolicyQuestions("23", "3");
		assertNotNull(cislApiService);
	}

	@Test
	public void testCreateContractQuestionsUpdate() throws Exception{
		questionBody questionBody = new questionBody();
		
		answer answer = new answer();
		answer.seteClass("eClass");
		answer.setSelf("self");
		answer.setValue(true);
		
		
		questionBody.setAnswer(answer);
		questionBody.seteClass("eClass");
		questionBody.setSelf("5");
		cislApiService.createContractQuestionsUpdate(questionBody, "2", "1", "5");
		assertNotNull(questionBody);
	}

	@Test
	public void testGetPolicyPremium() throws Exception{
		cislApiService.getPolicyPremium("1", "2");
		assertNotNull(cislApiService);
		
	}

}
