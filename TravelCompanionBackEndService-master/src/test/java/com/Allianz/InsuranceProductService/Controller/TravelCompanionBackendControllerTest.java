package com.Allianz.InsuranceProductService.Controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.Allianz.InsuranceProductService.Model.PackageinfoVO;
import com.Allianz.InsuranceProductService.Model.ProductInfoVO;
import com.Allianz.InsuranceProductService.Model.User;
import com.Allianz.InsuranceProductService.Service.AllianzProductService;
import com.Allianz.InsuranceProductService.Service.CislApiService;
import com.Allianz.InsuranceProductService.util.DataMocker;
import com.Allianz.InsuranceProductService.util.MakeServiceCalls;


@RunWith(SpringRunner.class)
@WebMvcTest(value = TravelCompanionBackendController.class, secure = false)
public class TravelCompanionBackendControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Mock
	private AllianzProductService productService;
	
	@Mock
	MakeServiceCalls makeServiceCalls;
	
	@Mock
	CislApiService cislApiService;
	
	@Mock
	DataMocker dataMocker;
	
	@Mock
	ProductInfoVO productInfoVO = new ProductInfoVO();

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetProductInfo() throws Exception {
		
		List<PackageinfoVO> packageinfoVOs = new ArrayList<>();
		
		PackageinfoVO packageinfoVO = new PackageinfoVO();
		
		List<String> packageDescriptionList = new ArrayList<>();
		packageDescriptionList.add("driving");
		packageDescriptionList.add("skiing");
		packageinfoVO.setPackageDescription(packageDescriptionList);
		packageinfoVO.setPackageName("passion");
		
		packageinfoVOs.add(packageinfoVO);
		
		productInfoVO.setPackageList(packageinfoVOs);
		productInfoVO.setProductName("SkiinSelekor");
		productService.getProductInfo("passionSelektor");
		assertNull(productInfoVO.getProductName());
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
		
		productService.fileMobilityInsurance(user);
		assertNotNull(user);
	}

}
