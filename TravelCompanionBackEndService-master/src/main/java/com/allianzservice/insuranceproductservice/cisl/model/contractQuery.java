/*
 * Travel Companion App inner layer
 */

package com.allianzservice.insuranceproductservice.cisl.model;

public class contractQuery {

	private String locale;
	private String logicalSection;
	private String eClass;
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getLogicalSection() {
		return logicalSection;
	}
	public void setLogicalSection(String logicalSection) {
		this.logicalSection = logicalSection;
	}
	public String geteClass() {
		return eClass;
	}
	public void seteClass(String eClass) {
		this.eClass = eClass;
	}
	public contractQuery(String locale,String logicalSection,String eClass) 
	{
		this.locale=locale;
		this.logicalSection=logicalSection;
		this.eClass=eClass;
	}
	public contractQuery(){
		// Do nothing
	}
}
