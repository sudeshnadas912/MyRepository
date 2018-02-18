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
package com.Allianz.InsuranceProductService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="User_Mobility_Insurance")
public class User {

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_Id")
	private long userId;
	
	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}

	@NotNull
	@Column(name="userName")
	private String userName;
	
	@NotNull
	@Column(name="selected_Package")
	private String slectedPackage;
	

	@NotNull
	@Column(name="selected_Module")
	private String slectedModule;
	
	@NotNull
	@Column(name="Total_Price")
	private int totalPrice;

	@NotNull
	@Column(name="Package_Title")
	private String packageTitle;
	
	@Column(name="File_Date")
	private String filedDate;
	
	@NotNull
	@Column(name="place")
	private String place;
	
	@Column(name="travel_date")
	private String travelDate;
	
	@NotNull
	@Column(name="varied_price")
	private float variedPrice;
	
	@NotNull
	@Column(name="weather")
	private String weather;
	
	@NotNull
	@Column(name="travelEndDate")
	private String travelEndDate;
	
	
	
	public String getTravelEndDate() {
		return travelEndDate;
	}



	public void setTravelEndDate(String travelEndDate) {
		this.travelEndDate = travelEndDate;
	}



	public String getWeather() {
		return weather;
	}



	public void setWeather(String weather) {
		this.weather = weather;
	}







	public float getVariedPrice() {
		return variedPrice;
	}



	public void setVariedPrice(float variedPrice) {
		this.variedPrice = variedPrice;
	}



	public String getPlace() {
		return place;
	}



	public void setPlace(String place) {
		this.place = place;
	}



	public String getTravelDate() {
		return travelDate;
	}



	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}



	public String getFiledDate() {
		return filedDate;
	}



	public void setFiledDate(String filedDate) {
		this.filedDate = filedDate;
	}



	public String getPackageTitle() {
		return packageTitle;
	}



	public void setPackageTitle(String packageTitle) {
		this.packageTitle = packageTitle;
	}



	public String getUserName() {
		return userName;
	}

	

	public String getSlectedModule() {
		return slectedModule;
	}



	public void setSlectedModule(String slectedModule) {
		this.slectedModule = slectedModule;
	}



	public String getSlectedPackage() {
		return slectedPackage;
	}

	public void setSlectedPackage(String slectedPackage) {
		this.slectedPackage = slectedPackage;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public User()
	{
		//Do nothing
	}
}
