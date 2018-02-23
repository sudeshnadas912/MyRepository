package com.allianzservice.insuranceproductservice.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.allianzservice.insuranceproductservice.util.AccessTokenUtil;
import com.allianzservice.insuranceproductservice.util.MakeCislCall;

@RunWith(SpringRunner.class)
public class MakeCislCallTest {
	
	AccessTokenUtil accessTokenUtil = new AccessTokenUtil();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreatePostRequest() throws Exception {
		MakeCislCall makeCislCall = new MakeCislCall();
		thrown.expect(NullPointerException.class);
		makeCislCall.createPostRequest(null);
		throw new NullPointerException();
	}

	@Test
	public void testCreateGetRequest() throws Exception {
		MakeCislCall makeCislCall = new MakeCislCall();
		thrown.expect(NullPointerException.class);
		makeCislCall.createGetRequest(null);
		throw new NullPointerException();
		
	}

}
