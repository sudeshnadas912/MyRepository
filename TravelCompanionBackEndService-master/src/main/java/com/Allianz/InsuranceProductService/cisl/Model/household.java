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

public class household {

	private String self;
	private String eClass;
	private String membersCount;
	private String houseHoldRole;
	private String numberOfChildren;
	private String numberOfVehicles;
	private String[] members;
	
	public household(String self,String eClass,String membersCount,String houseHoldRole,String numberOfChildren,String numberOfVehicles,String[] members)
	{
		this.self=self;
		this.eClass=eClass;
		this.membersCount=membersCount;
		this.houseHoldRole=houseHoldRole;
		this.numberOfChildren=numberOfChildren;
		this.numberOfVehicles=numberOfVehicles;
		this.members=members;
		}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String geteClass() {
		return eClass;
	}
	public void seteClass(String eClass) {
		this.eClass = eClass;
	}
	public String getMembersCount() {
		return membersCount;
	}
	public void setMembersCount(String membersCount) {
		this.membersCount = membersCount;
	}
	public String getHouseHoldRole() {
		return houseHoldRole;
	}
	public void setHouseHoldRole(String houseHoldRole) {
		this.houseHoldRole = houseHoldRole;
	}
	public String getNumberOfChildren() {
		return numberOfChildren;
	}
	public void setNumberOfChildren(String numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}
	public String getNumberOfVehicles() {
		return numberOfVehicles;
	}
	public void setNumberOfVehicles(String numberOfVehicles) {
		this.numberOfVehicles = numberOfVehicles;
	}
	public String[] getMembers() {
		return members;
	}
	public void setMembers(String[] members) {
		this.members = members;
	}
	
	
}
