package com.Allianz.InsuranceProductService.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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

import com.Allianz.InsuranceProductService.Service.AplService;
import com.Allianz.InsuranceProductService.cisl.Model.AplPackageRequestBody;
import com.Allianz.InsuranceProductService.cisl.Model.Passion;
import com.Allianz.InsuranceProductService.util.MakeServiceCalls;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(APLServiceController.class)
public class APLServiceControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private AplService aplService;
	
	@Mock
	MakeServiceCalls makeServiceCalls;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllPackageDetails () throws Exception {
		Passion mockPassion = new Passion();
		mockPassion.setAreaDescrs("area");
		mockPassion.setAttrDescrs("desc");
		mockPassion.setCaption("caption");
		mockPassion.setFields("field");
		mockPassion.setUname("uname");
		
		
//		
//		List<Passion> passionList = new ArrayList<>();
//		passionList.add(mockPassion);
//		passionList.add(mockPassion1);
//		
		String expectedJson = this.mapToJson(mockPassion);
		String uri="/apl/getAllPackageDetails";
		Mockito.when(aplService.getAllExistingPassion()).thenReturn(expectedJson);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
		
		
	}

	@Test
	public void testCreateProductInstance() throws Exception{
		Passion mockPassion = new Passion();
		mockPassion.setAreaDescrs("area");
		mockPassion.setAttrDescrs("desc");
		mockPassion.setCaption("caption");
		mockPassion.setFields("field");
		mockPassion.setUname("uname");
		
		String inputInJson = this.mapToJson(mockPassion);
		String uri="/apl/createProductInstance";
		Mockito.when(aplService.createProductInstance()).thenReturn(inputInJson);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON).content(inputInJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(),response.getStatus());
	}
	
	private String mapToJson(Object object) throws JsonProcessingException{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	@Test
	public void testFetchPackageComponents() throws Exception{
		Passion mockPassion = new Passion();
		mockPassion.setAreaDescrs("area");
		mockPassion.setAttrDescrs("desc");
		mockPassion.setCaption("caption");
		mockPassion.setFields("field");
		mockPassion.setUname("uname");
		
		AplPackageRequestBody aplPackageRequestBody = new AplPackageRequestBody();
		aplPackageRequestBody.setPackageName("SkiinSelector");
		aplPackageRequestBody.setUrl("test");
		
		String expectedJson = this.mapToJson(mockPassion);
		String uri="/apl/fetchPackageComponents";
		Mockito.when(aplService.fetchComponentsFromSelector(Mockito.anyString(), Mockito.anyString())).thenReturn(expectedJson);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo("");
		
	}

}
