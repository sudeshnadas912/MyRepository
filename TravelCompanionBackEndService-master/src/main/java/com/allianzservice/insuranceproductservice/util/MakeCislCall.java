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
package com.allianzservice.insuranceproductservice.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequestWithBody;

@Component
public class MakeCislCall {

	private static final Logger logger = Logger.getLogger(MakeCislCall.class.getName());

	@Value("${cisl.base.url}")
	private String cislBaseUri;

	@Autowired
	private AccessTokenUtil accessTokenUtil;

	public HttpRequestWithBody createPostRequest(String servicePostFix) throws UnirestException {
		logger.info("url-->" + cislBaseUri + servicePostFix);
		return Unirest.post(cislBaseUri + servicePostFix).header("accept", "application/json").header("Authorization",
				"Bearer " + accessTokenUtil.getAccessToken());
	}

	public GetRequest createGetRequest(String servicePostFix) throws UnirestException {
		return Unirest.get(cislBaseUri + servicePostFix).header("accept", "application/json").header("Authorization",
				"Bearer " + accessTokenUtil.getAccessToken());
	}

}
