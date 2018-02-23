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
package com.allianzservice.insuranceproductservice.cisl.model;

public class contractPartiesBody {

	private String degree;
	private String self;
	private String eClass;
	private String gender;
	private String lastName;
	private String firstName;
	private String nameAffix;
	private String middleName;
	private String dateOfBirth;
	private String occupation;
	private String maritalStatus;
	private String employmentStatus ;
	private String socialSecurityNumber;
	
	public contractPartiesBody(String degree,String self,String eClass,String gender,String lastName,String firstName,String nameAffix,String middleName,
			String dateOfBirth,String occupation,String maritalStatus,String employmentStatus)
	{
		this.degree=degree;
		this.self=self;
		this.eClass=eClass;
		this.gender=gender;
		this.lastName=lastName;
		this.firstName=firstName;
		this.nameAffix=nameAffix;
		this.middleName=middleName;
		this.dateOfBirth=dateOfBirth;
		this.occupation=occupation;
		this.maritalStatus=maritalStatus;
		this.employmentStatus=employmentStatus;
		
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getNameAffix() {
		return nameAffix;
	}
	public void setNameAffix(String nameAffix) {
		this.nameAffix = nameAffix;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getEmploymentStatus() {
		return employmentStatus;
	}
	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	
	public contractPartiesBody() {
		// Do nothing
	}
}
