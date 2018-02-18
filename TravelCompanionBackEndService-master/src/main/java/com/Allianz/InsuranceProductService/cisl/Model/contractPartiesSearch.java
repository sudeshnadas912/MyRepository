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

public class contractPartiesSearch {

	private String lead;
	private String self;
	private String eClass;
	private String gender;
	private String lastName;
	private String firstName;
	private String partySign;
	private String dateOfBirth;
	private String nationality;
	private String maritalStatus;
	private String accountManager;
	private String policyHolderType;
	private String preferredLanguage;
	private String accountManagerNumber;
	private String preferredPaymentMethod;
	private String preferPaperlessCommunication;
	private household household;
	
	public contractPartiesSearch(String lead,String self,String eClass,String gender,String lastName,String firstName,String partySign,String dateOfBirth,String nationality,String martialStatus,
			String accountManager,String policyHolderType,String preferredLanguage,String accountManagerNumber,String preferredPaymentMethod,String preferPaperlessCommunication,household household)
	{
		
		this.lead=lead;
		this.self=self;
		this.eClass=eClass;
		this.gender=gender;
		this.lastName=lastName;
		this.firstName=firstName;
		this.partySign=partySign;
		this.dateOfBirth=dateOfBirth;
		this.nationality=nationality;
		this.maritalStatus=martialStatus;
		this.accountManager=accountManager;
		this.policyHolderType=policyHolderType;
		this.preferredLanguage=preferredLanguage;
		this.accountManagerNumber=accountManagerNumber;
		this.preferredPaymentMethod=preferredPaymentMethod;
		this.preferPaperlessCommunication=preferPaperlessCommunication;
		this.household=household;
	}
	public String getLead() {
		return lead;
	}
	public void setLead(String lead) {
		this.lead = lead;
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
	public String getPartySign() {
		return partySign;
	}
	public void setPartySign(String partySign) {
		this.partySign = partySign;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getAccountManager() {
		return accountManager;
	}
	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}
	public String getPolicyHolderType() {
		return policyHolderType;
	}
	public void setPolicyHolderType(String policyHolderType) {
		this.policyHolderType = policyHolderType;
	}
	public String getPreferredLanguage() {
		return preferredLanguage;
	}
	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}
	public String getAccountManagerNumber() {
		return accountManagerNumber;
	}
	public void setAccountManagerNumber(String accountManagerNumber) {
		this.accountManagerNumber = accountManagerNumber;
	}
	public String getPreferredPaymentMethod() {
		return preferredPaymentMethod;
	}
	public void setPreferredPaymentMethod(String preferredPaymentMethod) {
		this.preferredPaymentMethod = preferredPaymentMethod;
	}
	public String getPreferPaperlessCommunication() {
		return preferPaperlessCommunication;
	}
	public void setPreferPaperlessCommunication(String preferPaperlessCommunication) {
		this.preferPaperlessCommunication = preferPaperlessCommunication;
	}
	public household getHousehold() {
		return household;
	}
	public void setHousehold(household household) {
		this.household = household;
	}
	public contractPartiesSearch()
	{
		//Do nothing
	}
	
	
}
