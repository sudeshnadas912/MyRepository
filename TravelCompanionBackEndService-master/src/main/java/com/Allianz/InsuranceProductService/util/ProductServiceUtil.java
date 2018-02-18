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
package com.Allianz.InsuranceProductService.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



@Component
@Qualifier("productServiceUtil")
public class ProductServiceUtil {
	
	private static final Logger logger = Logger.getLogger( ProductServiceUtil.class.getName() );

	public boolean checkStringContains(String stringToBeChecked, String keyString)
	{
		boolean bool=stringToBeChecked.contains(keyString);
		//System.out.println("To check whether "+stringToBeChecked+" contains "+keyString+" boolean value is -->"+ bool);
		return bool;
	}
	
	public boolean isDateWithinRange(String reminderDate, int days)
	{
		boolean flag=false;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 Date date = new Date();
		 try {
			date = df.parse(reminderDate);
			logger.info("dateformatted-->"+date);
			 for(int i=0;i<=days;i++)
			 {
			int differnce=DateUtils.truncatedCompareTo(date,DateUtils.addDays(new Date(), i),Calendar.DATE);
			logger.info("comparing --->"+date+"  with -->"+DateUtils.addDays(new Date(), i)+"  value==>"+differnce);
			if(differnce==0)
				{flag=true;
				logger.info("inside if");
				
				}
			logger.info("flag==>"+flag);
			
			 }
		} catch (ParseException e) {
			logger.error(e.getMessage());
		}
	return flag;
	}
	
	public JSONObject convertObjectToJSONObject(Object obj) throws JSONException
	{
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(obj);
		return new JSONObject(json);
	}
	
	public Object convertJsonStringToObject(String jsonResponse,Object obj)
	{
		Gson gson= new Gson();
		return gson.fromJson(jsonResponse, obj.getClass());
	}
	
	
}
