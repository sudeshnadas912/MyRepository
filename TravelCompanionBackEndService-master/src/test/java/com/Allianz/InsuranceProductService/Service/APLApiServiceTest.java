package com.Allianz.InsuranceProductService.Service;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.Allianz.InsuranceProductService.util.MakeServiceCalls;

@RunWith(SpringRunner.class)
public class APLApiServiceTest {
	
	@InjectMocks
	private APLApiService service;
	
	@Mock
	MakeServiceCalls makeServiceCalls;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllPackageNames() {
		thrown.expect(NullPointerException.class);
		service.getAllPackageNames();
		throw new NullPointerException();
		
	}
	
	

	@Test
	public void testCreateProductInstance() throws Exception {
		thrown.expect(NullPointerException.class);
		service.createProductInstance();
		throw new NullPointerException();
	}

}
