package com.allianzservice.insuranceproductservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.json.JSONException;
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
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.allianzservice.insuranceproductservice.model.PackageinfoVO;
import com.allianzservice.insuranceproductservice.model.ProductInfoVO;
import com.allianzservice.insuranceproductservice.util.MakeServiceCalls;



@RunWith(MockitoJUnitRunner.class)
public class APLApiServiceTest {
	
	@InjectMocks
	private APLApiService service;
	
	@Mock
	MakeServiceCalls makeServiceCalls;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllPackageNames() throws Exception {
		Client client = ClientBuilder.newClient();
		Mockito.when(makeServiceCalls.makeGetCall(client.target("https://apl.allianz.de.awin:443/catalogservice_gdf/rest/catalog;model=GDF/componentdefinition;uname=%3EA.Product.BO.GDF.Passion"))
				).thenReturn(Response.ok().build());
		thrown.expect(NullPointerException.class);
		service.getAllPackageNames();
		throw new NullPointerException();
				
	}
	
	

	@Test
	public void testCreateProductInstance() throws Exception {
		ProductInfoVO productInfoVO = new ProductInfoVO();
		productInfoVO.setProductName("pname");
		PackageinfoVO packageInfoVO = new PackageinfoVO();
		packageInfoVO.setPackageDescription(Arrays.asList("pkgdesc", "pkgdesc1"));
		packageInfoVO.setPackageName("mypackage");
		productInfoVO.setPackageList(Arrays.asList(packageInfoVO));
		assertEquals("Pkg size", 1, productInfoVO.getPackageList().size());
		assertEquals("ProductName", "pname", productInfoVO.getProductName());
		assertEquals("Pkg desc size", 2, packageInfoVO.getPackageDescription().size());
		assertEquals("Pkg name", "mypackage", packageInfoVO.getPackageName());
		JSONObject jSONObject = new JSONObject("{ \"prodref\":\"A.Product.PO.GDF.PassionPass\"}");
		Mockito.when(makeServiceCalls.makeHttpRestCall(jSONObject, "https://apl.allianz.de.awin:443/catalogservice_gdf/rest/config;model=GDF;", false, HttpMethod.POST)).thenReturn("success");
		assertNull(service.createProductInstance());
		
	}

}
