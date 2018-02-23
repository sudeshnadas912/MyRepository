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
package com.allianzservice.insuranceproductservice.controller;



import java.util.Date;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.allianzservice.insuranceproductservice.model.ProductInfoVO;
import com.allianzservice.insuranceproductservice.model.User;
import com.allianzservice.insuranceproductservice.service.AllianzProductService;
import com.google.gson.JsonSyntaxException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@PropertySource("classpath:application.properties")
@Api(value="Travel Companion Backend Service",description="backend Service calls for TravelCompanion Application")
public class TravelCompanionBackendController {


	@Autowired
	private AllianzProductService productService;
	
	private static final Logger logger = Logger.getLogger( TravelCompanionBackendController.class.getName() );
	
	
	//To get the product info from APL
	@ApiOperation("To get Product and components from APL Service")
	@GetMapping("/Product/{productName}")
	public ProductInfoVO getProductInfo(@PathVariable String productName) throws JsonSyntaxException, JSONException
	{
		logger.debug("in get Product Info call");
		
		
		return productService.getProductInfo(productName);
				
	}
	
	//create an policy in CISL
	@ApiOperation("To file the insurance policy")
	@PostMapping(value="/fileMobilityInsurance")
	public boolean fileMobilityInsurance(@RequestBody User user)
	{
		user.setFiledDate(new Date().toString());
		try
		{
		return productService.fileMobilityInsurance(user);
		}
		catch(Exception ex)
		{
			logger.error(ex.getMessage());
			return false;
		}
	}
	
	//To test inner-outer connection
	@ApiOperation("To Test Inner-outer connection")
	@GetMapping(value="/testInnerOuter")
	public String testInnerOuterConnection()
	{
			return "Welcome to Inner Layer";
	}
	
}
