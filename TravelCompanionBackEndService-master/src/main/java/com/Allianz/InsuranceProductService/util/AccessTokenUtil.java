/*******************************************************************************
 * Copyright 2018 TCS
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.Allianz.InsuranceProductService.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.Allianz.InsuranceProductService.Model.AccessToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
@Component
public class AccessTokenUtil {
	@Value("${cisl.base.url}")
	private  String cislUrl;
	
	@Value("${cisl.oauth.url}")
	private  String oAuthUrl;
	
	@Value("${cisl.oauth.accessTypeJson}")
	private String cislAccessMediaType;
	
	@Value("${cisl.oauth.clientID}")
	private String clientId;
	
	@Value("${cisl.oauth.clientSecret}")
	private String clientSecret;
	
	@Value("${cisl.oauth.grantType}")
	private String grantType;
	
	
	private static final Logger logger = Logger.getLogger(AccessTokenUtil.class.getName());
	
	public  String getAccessToken() throws UnirestException
	{
		
		HttpResponse<AccessToken> jsonResponse;
		try {
			System.out.println("IP Address-->"+InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			logger.error(e.getMessage());
		}
			jsonResponse = Unirest.post(cislUrl+oAuthUrl)
						.header("accept", cislAccessMediaType)
						.field("client_id", clientId)
						.field("client_secret", clientSecret)
						.field("grant_type", grantType)
						.asObject(AccessToken.class);
			logger.info("token-->"+((AccessToken)jsonResponse.getBody()).getAccessToken());
		
			return ((AccessToken)jsonResponse.getBody()).getAccessToken();
	}
}
