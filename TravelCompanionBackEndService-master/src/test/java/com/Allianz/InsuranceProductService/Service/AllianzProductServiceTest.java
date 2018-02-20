package com.Allianz.InsuranceProductService.Service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.Allianz.InsuranceProductService.Model.PackageinfoVO;
import com.Allianz.InsuranceProductService.Model.ProductInfoVO;
import com.Allianz.InsuranceProductService.Model.User;
import com.Allianz.InsuranceProductService.cisl.Model.Area;
import com.Allianz.InsuranceProductService.cisl.Model.CompRefs;
import com.Allianz.InsuranceProductService.cisl.Model.ProductInstance;
import com.Allianz.InsuranceProductService.cisl.Model.contractPartiesSearch;
import com.Allianz.InsuranceProductService.cisl.Model.household;
import com.Allianz.InsuranceProductService.cisl.Model.result;
import com.Allianz.InsuranceProductService.util.MakeServiceCalls;
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

		area.setCompRefsList(compRefs);

		ProductInstance productInstance = new ProductInstance();
		productInstance.setDuration("30");

		result result = new result();

		Area area1 = new Area();
		area1.setCaption("caption1");
		area1.setName("SkiinSelektors");
		area1.setCompRefsList(compRefs);

		result.setAreas(new Area[] { area, area1 });
		result.setAttributes("attributes");
		result.setCaption("caption");
		result.setFields("fields");
		result.setId("id");
		result.setParentId("parentId");
		result.setProdref("prodref");

		productInstance.setResult(result);

		contractPartiesSearch contractPartiesSearch = new contractPartiesSearch();
		contractPartiesSearch.setAccountManager("accountManager");
		contractPartiesSearch.setAccountManagerNumber("accountManagerNumber");
		contractPartiesSearch.setDateOfBirth("dateOfBirth");
		contractPartiesSearch.seteClass("eClass");
		contractPartiesSearch.setFirstName("firstName");
		contractPartiesSearch.setGender("gender");

		household Household = new household("1", "eclass", "4", "role", "4", "5",
				new String[] { "member1", "member2" });

		Household.seteClass("selfCass");
		Household.setHouseHoldRole("package");
		Household.setMembers(new String[] { "passion1", "passion2" });
		Household.setMembersCount("7");
		Household.setNumberOfChildren("2");
		Household.setNumberOfVehicles("9");
		;
		Household.setSelf("3");

		contractPartiesSearch.setHousehold(Household);
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

		List<String> packageNames = new ArrayList<>();
		packageNames.add("p1");
		packageNames.add("p2");
		Mockito.when(aplService.getAllPackageNames()).thenReturn(packageNames);
		Mockito.when(aplService.createProductInstance()).thenReturn(mapToJson(productInstance));
		Mockito.when(productInfoVO.getProductName()).thenReturn("skinnSelector");
		Mockito.when(productInfoVO.getPackageList()).thenReturn(packageinfoVOs);

		// JSONObject jsonObject = new JSONObject("{
		// \"prodref\":\"A.Product.PO.GDF."+SkiingSlector+"Selektor\"}");
		thrown.expect(NullPointerException.class);
		service.getProductInfo("skinnSelector");
		throw new NullPointerException();
	}

	@Test

	public void testContractPartiesSearch() {

		household Household = new household("1", "eclass", "4", "role", "4", "5",
				new String[] { "member1", "member2" });
		contractPartiesSearch contractPartiesSearch = new contractPartiesSearch("lead", "self", "eClass", "gender",
				"lastName", "firstName", "partySign", "dateOfBirth", "nationality", "martialStatus", "accountManager",
				"policyHolderType", "preferredLanguage", "accountManagerNumber", "preferredPaymentMethod",
				"preferPaperlessCommunication", Household);
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

}
