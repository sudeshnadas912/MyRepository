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
package com.Allianz.InsuranceProductService.Controller;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Allianz.InsuranceProductService.Service.AplService;
import com.Allianz.InsuranceProductService.cisl.Model.AplPackageRequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/apl")
@Api(value = "APL Service Calls", description = "To interact with APL services")
public class APLServiceController {

	private static final Logger LOGGER = Logger.getLogger(CislServiceController.class.getName());

	@Autowired
	private AplService aplService;

	
	// APL implementation (Start)

	// To fetch all the Package details
	@ApiOperation("To get all Package Details(Package Name)")
	@GetMapping(value = "/getAllPackageDetails", produces = "application/json")
	public String getAllPackageDetails() throws JSONException {
		return aplService.getAllExistingPassion();

	}

	// Create a Product Instance
	@ApiOperation("To create Product Instance")
	@PostMapping("/createProductInstance")
	public String createProductInstance() throws JSONException {
		return aplService.createProductInstance();

	}

	// To fetch package Components from Selector
	@ApiOperation("To fetch package Components from Selector")
	@PostMapping("/fetchPackageComponents")
	public String fetchPackageComponents(@RequestBody AplPackageRequestBody aplPackageRequestBody)
			throws JSONException {
		LOGGER.info("url -->" + aplPackageRequestBody.getUrl() + "  packageName-->"
				+ aplPackageRequestBody.getPackageName());
		return aplService.fetchComponentsFromSelector(aplPackageRequestBody.getUrl(),
				aplPackageRequestBody.getPackageName());

	}

}
