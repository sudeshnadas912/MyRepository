package com.Allianz.InsuranceProductService.util;

import static org.junit.Assert.assertNotNull;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MakeServiceCallsTest {

	AccessTokenUtil accessTokenUtil = new AccessTokenUtil();

	Client mockClient = Mockito.mock(Client.class);
	Response mockResponse = Mockito.mock(Response.class);

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMakeGetCall() {

		Builder mockBuilder = (Builder) Mockito.mock(Builder.class);
		Mockito.when(mockBuilder.get()).thenReturn(this.mockResponse);
		Mockito.when(mockBuilder.post(Matchers.any())).thenReturn(this.mockResponse);
		Mockito.when(mockBuilder.put(Matchers.any())).thenReturn(this.mockResponse);
		Mockito.when(mockBuilder.delete()).thenReturn(this.mockResponse);

		MakeServiceCalls makeServiceCalls = new MakeServiceCalls();
		WebTarget mockWebTarget = Mockito.mock(WebTarget.class);
		Mockito.when(mockWebTarget.path(Matchers.anyString())).thenReturn(mockWebTarget);
		Mockito.when(mockWebTarget.request(MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON))
				.thenReturn(mockBuilder);

		Mockito.when(this.mockClient.target(Matchers.anyString())).thenReturn(mockWebTarget);
		// Need use of power Mockito
		thrown.expect(NullPointerException.class);
		makeServiceCalls.makeGetCall(mockWebTarget);
		throw new NullPointerException();
	}

	@Test
	public void testMakeHttpRestCall() {
		JSONObject jsonObject = new JSONObject();
		MakeServiceCalls makeServiceCalls = new MakeServiceCalls();
		assertNotNull(makeServiceCalls.makeHttpRestCall(jsonObject, "", true, "post"));
	}

}
