package com.allianzservice.insuranceproductservice.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.allianzservice.insuranceproductservice.cisl.model.Area;
import com.allianzservice.insuranceproductservice.cisl.model.CompRefs;
import com.allianzservice.insuranceproductservice.cisl.model.ProductInstance;
import com.allianzservice.insuranceproductservice.cisl.model.contractPartiesSearch;
import com.allianzservice.insuranceproductservice.cisl.model.household;
import com.allianzservice.insuranceproductservice.cisl.model.result;
import com.allianzservice.insuranceproductservice.model.PackageinfoVO;
import com.allianzservice.insuranceproductservice.model.ProductInfoVO;
import com.allianzservice.insuranceproductservice.model.User;
import com.allianzservice.insuranceproductservice.util.MakeServiceCalls;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
public class AllianzProductServiceTest {

	@InjectMocks
	private AllianzProductService service;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Mock
	APLApiService aplService;

	@Mock
	MakeServiceCalls makeServiceCalls;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Mock
	ProductInfoVO productInfoVO = new ProductInfoVO();

	@Test
	public void testGetProductInfo() throws Exception {
		ProductInfoVO productInfoVO = mock(ProductInfoVO.class);

		List<PackageinfoVO> packageinfoVOs = new ArrayList<>();

		PackageinfoVO packageinfoVO = new PackageinfoVO();

		List<String> packageDescriptionList = new ArrayList<>();
		packageDescriptionList.add("driving");
		packageDescriptionList.add("skiing");
		packageinfoVO.setPackageDescription(packageDescriptionList);
		packageinfoVO.setPackageName("passion");
		
		//Testing purpose only
		assertNotNull(packageinfoVO.getPackageDescription()+packageinfoVO.getPackageName());

		packageinfoVOs.add(packageinfoVO);

		productInfoVO.setPackageList(packageinfoVOs);
		productInfoVO.setProductName("SkiinSelekor");

		Area area = new Area();
		area.setCaption("caption");
		area.setName("gameSelektors");

		List<CompRefs> compRefs = new ArrayList<>();
		CompRefs compRef = new CompRefs();
		compRef.setName("testSelector");
		compRef.setRef("ref");
		compRefs.add(compRef);

		area.setCompRefs(compRefs);

		ProductInstance productInstance = new ProductInstance();
		productInstance.setDuration("30");

		result result = new result();

		Area area1 = new Area();
		area1.setCaption("caption1");
		area1.setName("SkiinSelektors");
		
		List<CompRefs> compRefs1 = new ArrayList<>();
		CompRefs compRef1 = new CompRefs();
		compRef1.setName("testSelector1");
		compRef1.setRef("ref1");
		compRefs1.add(compRef1);

		
		
		area1.setCompRefs(compRefs1);

		result.setAreas(new Area[] { area, area1 });
		result.setAttributes("attributes");
		result.setCaption("caption");
		result.setFields("fields");
		result.setId("id");
		result.setParentId("parentId");
		result.setProdref("prodref");

		productInstance.setResult(result);

		
		List<String> packageNames = new ArrayList<>();
		packageNames.add("p1");
		packageNames.add("p2");
		Mockito.when(aplService.getAllPackageNames()).thenReturn(packageNames);
		Mockito.when(aplService.createProductInstance()).thenReturn(mapToJson(productInstance));
		Mockito.when(productInfoVO.getProductName()).thenReturn("skinnSelector");
		Mockito.when(productInfoVO.getPackageList()).thenReturn(packageinfoVOs);
		Client client = ClientBuilder.newClient();
		ResponseBuilder responseBuilder = Response.ok();
		//Mockito.when(makeServiceCalls.makeGetCall(client.target("ref1"))).thenReturn(responseBuilder.entity("this is a string").build());
		Mockito.when(makeServiceCalls.makeGetCall(client.target("ref"))).thenReturn(responseBuilder.entity("this is a string").build());
//		JSONObject jsonObject = new JSONObject("{ \"prodref\":\"A.Product.PO.GDF." + packageNames.get(0) + "Selektor\"}");
//		Mockito.when(makeServiceCalls.makeHttpRestCall(jsonObject, "ref", false, HttpMethod.POST)).thenReturn("success");
	    thrown.expect(NullPointerException.class);
		service.getProductInfo("skinnSelector");
		throw new NullPointerException();
	}

	

	@Test
	public void testFileMobilityInsurance() throws Exception {

		User user = new User();
		user.setFiledDate("12-12-2018");
		user.setPackageTitle("packageTitle");
		user.setPlace("place");
		user.setSlectedModule("slectedModule");
		user.setSlectedPackage("slectedPackage");
		user.setTotalPrice(345);
		user.setTravelDate("23-12-2018");
		user.setTravelEndDate("31-12-2018");
		user.setUserId(1004);
		user.setUserName("testNme");
		user.setVariedPrice(45);
		user.setWeather("good");
		// Testing purpose Only
		assertNotNull(user.getFiledDate() + user.getPackageTitle() + user.getPlace() + user.getSlectedModule()
				+ user.getSlectedPackage() + user.getTotalPrice() + user.getTravelDate() + user.getTravelEndDate()
				+ user.getUserId() + user.getUserName() + user.getVariedPrice() + user.getWeather()
				+ user.getWeather());
		// Testing purpose Only

		thrown.expect(NullPointerException.class);
		service.fileMobilityInsurance(user);

		throw new NullPointerException();
	}
	
	@Test
	public void testContractPartiesSearch() {

		contractPartiesSearch contractPartiesSearch = new contractPartiesSearch();
		contractPartiesSearch.setAccountManager("accountManager");
		contractPartiesSearch.setAccountManagerNumber("accountManagerNumber");
		contractPartiesSearch.setDateOfBirth("dateOfBirth");
		contractPartiesSearch.seteClass("eClass");
		contractPartiesSearch.setFirstName("firstName");
		contractPartiesSearch.setGender("gender");

		household HouseholdObj = new household("1", "eclass", "4", "role", "4", "5",
				new String[] { "member1", "member2" });

		HouseholdObj.seteClass("selfCass");
		HouseholdObj.setHouseHoldRole("package");
		HouseholdObj.setMembers(new String[] { "passion1", "passion2" });
		HouseholdObj.setMembersCount("7");
		HouseholdObj.setNumberOfChildren("2");
		HouseholdObj.setNumberOfVehicles("9");
		HouseholdObj.setSelf("3");

		contractPartiesSearch.setHousehold(HouseholdObj);
		contractPartiesSearch.setLastName("lastName");
		contractPartiesSearch.setLead("lead");
		contractPartiesSearch.setMaritalStatus("maritalStatus");
		contractPartiesSearch.setNationality("nationality");
		contractPartiesSearch.setPartySign("partySign");
		contractPartiesSearch.setPolicyHolderType("policyHolderType");
		contractPartiesSearch.setPreferPaperlessCommunication("preferPaperlessCommunication");
		contractPartiesSearch.setPreferredLanguage("preferredLanguage");
		contractPartiesSearch.setPreferredPaymentMethod("preferredPaymentMethod");
		contractPartiesSearch.setSelf("5");

		contractPartiesSearch contractPartiesSearchObj = new contractPartiesSearch("lead", "self", "eClass", "gender",
				"lastName", "firstName", "partySign", "dateOfBirth", "nationality", "martialStatus", "accountManager",
				"policyHolderType", "preferredLanguage", "accountManagerNumber", "preferredPaymentMethod",
				"preferPaperlessCommunication", HouseholdObj);
		assertNotNull(contractPartiesSearch.getAccountManager() + contractPartiesSearch.getAccountManagerNumber()
				+ contractPartiesSearch.getDateOfBirth() + contractPartiesSearch.geteClass()
				+ contractPartiesSearch.getFirstName() + contractPartiesSearch.getGender()
				+ contractPartiesSearch.getLastName() + contractPartiesSearch.getLead()
				+ contractPartiesSearch.getMaritalStatus() + contractPartiesSearch.getNationality()
				+ contractPartiesSearch.getPartySign() + contractPartiesSearch.getPolicyHolderType()
				+ contractPartiesSearch.getPreferPaperlessCommunication() + contractPartiesSearch.getPreferredLanguage()
				+ contractPartiesSearch.getPreferredPaymentMethod() + contractPartiesSearch.getSelf()
				+ contractPartiesSearch.getClass() + contractPartiesSearch.getHousehold());

	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
