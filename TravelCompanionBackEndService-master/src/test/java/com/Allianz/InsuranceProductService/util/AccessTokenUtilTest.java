package com.Allianz.InsuranceProductService.util;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Allianz.InsuranceProductService.Model.AccessToken;;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccessTokenUtilTest {

	
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
	public void testGetAccessToken() throws Exception{
		thrown.expect(Exception.class);
		AccessToken accessToken = new AccessToken();
		accessToken.setAccessToken("456");
		accessToken.setExpiresSeconds("2");
		accessToken.setTokenType("client-credential");
		assertNotNull(accessToken);
		accessTokenUtil.getAccessToken();
		throw new Exception();
	} 
	

}
