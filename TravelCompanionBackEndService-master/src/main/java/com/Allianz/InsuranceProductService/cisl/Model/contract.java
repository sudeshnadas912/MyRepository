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
package com.Allianz.InsuranceProductService.cisl.Model;

public class contract {
	
	private String eClass;
	private String self;
	private String contractProcessStadium;
	private String policyIssuingType;
	public String geteClass() {
		return eClass;
	}
	public void seteClass(String eClass) {
		this.eClass = eClass;
	}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getContractProcessStadium() {
		return contractProcessStadium;
	}
	public void setContractProcessStadium(String contractProcessStadium) {
		this.contractProcessStadium = contractProcessStadium;
	}
	public String getPolicyIssuingType() {
		return policyIssuingType;
	}
	public void setPolicyIssuingType(String policyIssuingType) {
		this.policyIssuingType = policyIssuingType;
	}
	
	

}
