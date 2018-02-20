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

public class propertyBody {
	
	private String eClass;
	private String[] owners;
	private characteristics characteristics;
	private String vehicleIdentificationNumber;
	public String geteClass() {
		return eClass;
	}
	public void seteClass(String eClass) {
		this.eClass = eClass;
	}
	public String[] getOwners() {
		return owners.clone();
	}
	public void setOwners(String[] owners) {
		this.owners = owners.clone();
	}
	public characteristics getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(characteristics characteristics) {
		this.characteristics = characteristics;
	}
	public String getVehicleIdentificationNumber() {
		return vehicleIdentificationNumber;
	}
	public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
		this.vehicleIdentificationNumber = vehicleIdentificationNumber;
	}
	

}
