package com.Allianz.InsuranceProductService.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.Allianz.InsuranceProductService.cisl.Model.Passion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceUtilTest {
	
	ProductServiceUtil productServiceUtil = new ProductServiceUtil();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckStringContains() {
		assertTrue(productServiceUtil.checkStringContains("PassionPassSelector", "Selector"));
	}

	@Test
	public void testIsDateWithinRange() {
		assertFalse(productServiceUtil.isDateWithinRange("12/12/2017", 6));
	}
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	@Test
	public void testConvertObjectToJSONObject() throws Exception {
		
		Passion mockPassion = new Passion();
		mockPassion.setAreaDescrs("area");
		mockPassion.setAttrDescrs("desc");
		mockPassion.setCaption("caption");
		mockPassion.setFields("field");
		mockPassion.setUname("uname");
		
		assertNotNull(productServiceUtil.convertObjectToJSONObject(mockPassion));
	}

	@Test
	public void testConvertJsonStringToObject() throws Exception {
		
		Passion mockPassion = new Passion();
		mockPassion.setAreaDescrs("area");
		mockPassion.setAttrDescrs("desc");
		mockPassion.setCaption("caption");
		mockPassion.setFields("field");
		mockPassion.setUname("uname");
		
		assertNotNull(productServiceUtil.convertJsonStringToObject(mapToJson(mockPassion), mockPassion));
		
	}

}
