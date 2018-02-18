package com.Allianz.InsuranceProductService.config;

import static org.junit.Assert.*;

import java.security.cert.CertificateException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class NOOPTrustManagerTest {
	NOOPTrustManager nOOPTrustManager = new NOOPTrustManager();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
		nOOPTrustManager.checkClientTrusted(null, "");
		nOOPTrustManager.checkServerTrusted(null, "");
		assertNotNull(nOOPTrustManager);
	}

}
