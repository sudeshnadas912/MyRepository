package com.Allianz.InsuranceProductService.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.Allianz.InsuranceProductService.cisl.Model.contractPartiesBody;
import com.Allianz.InsuranceProductService.cisl.Model.contractQuery;

@RunWith(MockitoJUnitRunner.class)
public class DataMockerTest {
	
	DataMocker dataMocker = new DataMocker();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetMockOfObject() {
		contractQuery contractQuery = new contractQuery();
		dataMocker.getMockOfObject(contractQuery);
		assertNotNull(contractQuery);
		contractPartiesBody contractPartiesBody = new contractPartiesBody();
		dataMocker.getMockOfObject(contractPartiesBody);
		assertNotNull(contractPartiesBody);
	}

}
