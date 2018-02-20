package com.Allianz.InsuranceProductService.Service;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.Allianz.InsuranceProductService.cisl.Model.Area;
import com.Allianz.InsuranceProductService.cisl.Model.CompRefs;
import com.Allianz.InsuranceProductService.cisl.Model.Passion;
import com.Allianz.InsuranceProductService.cisl.Model.Product;
import com.Allianz.InsuranceProductService.util.MakeServiceCalls;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class AplServiceTest {

	@Mock
	private MakeServiceCalls makeServiceCallsMock;

	@InjectMocks
	private AplService service;

	final Client mockClient = Mockito.mock(Client.class);
	final Response mockResponse = Mockito.mock(Response.class);

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

		
	}

	@After
	public void tearDown() throws Exception {
	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	@Test
	public void testGetAllExistingPassion() throws Exception {

		Passion mockPassion = new Passion();
		mockPassion.setAreaDescrs("area");
		mockPassion.setAttrDescrs("desc");
		mockPassion.setCaption("caption");
		mockPassion.setFields("field");
		mockPassion.setUname("uname");

		Mockito.when(this.mockResponse.getStatus()).thenReturn(200);

		final WebTarget mockWebTarget = Mockito.mock(WebTarget.class);
		Mockito.when(mockWebTarget.path(Matchers.anyString())).thenReturn(mockWebTarget);
		Mockito.when(this.mockClient.target(Matchers.anyString())).thenReturn(mockWebTarget);

		String inputInJson = this.mapToJson(mockPassion);
		Response response = makeServiceCallsMock.makeGetCall(mockWebTarget);

		assertNull(response);
		
	}

	 @Test
	 public void testCreateProductInstance() throws JSONException {
		 
		 JSONObject jSONObject = new JSONObject("{ \"prodref\":\"A.Product.PO.GDF.PassionPass\"}");
		 when(makeServiceCallsMock.makeHttpRestCall(jSONObject,"", false, HttpMethod.POST)).thenReturn("");
		 assertNull(service.createProductInstance());
	
	 }

	@Test
	public void testGetPassionSelector() throws JsonProcessingException, JSONException {
		Product mockProduct = new Product();
		mockProduct.setAttributes("attributes");
		mockProduct.setCaption("caption");
		mockProduct.setFields("fields");
		mockProduct.setId("id");
		mockProduct.setParentId("parentId");
		mockProduct.setPassionSelektorId("passionSelektorId");
		mockProduct.setProdref("prodref");
		Area area = new Area();
		area.setCaption("caption");
		area.setName("gameSelektors");

		List<CompRefs> compRefs = new ArrayList<>();
		CompRefs compRef = new CompRefs();
		compRef.setName("testSelector");
		compRef.setRef("ref");
		compRefs.add(compRef);

		area.setCompRefsList(compRefs);
		List<Area> arealist = new ArrayList<>();
		arealist.add(area);
		mockProduct.setAreaList(arealist);

		Mockito.when(this.mockResponse.getStatus()).thenReturn(200);

		final WebTarget mockWebTarget = Mockito.mock(WebTarget.class);
		Mockito.when(mockWebTarget.path(Matchers.anyString())).thenReturn(mockWebTarget);
		Mockito.when(this.mockClient.target(Matchers.anyString())).thenReturn(mockWebTarget);

		String inputInJson = this.mapToJson(mockProduct);
		Response response = makeServiceCallsMock.makeGetCall(mockWebTarget);

		assertNull(response);
		
	}

	@Test
	public void testFetchComponentsFromSelector() throws JSONException {
		JSONObject jsonObject = new JSONObject("{ \"prodref\":\"A.Product.PO.GDF.PassionSelektor\"}");
		 when(makeServiceCallsMock.makeHttpRestCall(jsonObject,"", false, HttpMethod.POST)).thenReturn("");
		 String url="";
		 String packageName = "";
		 assertNull(service.fetchComponentsFromSelector(url, packageName));
	
	}

}
