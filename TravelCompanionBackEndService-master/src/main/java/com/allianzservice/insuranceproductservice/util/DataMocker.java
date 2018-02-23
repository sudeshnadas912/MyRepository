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
package com.allianzservice.insuranceproductservice.util;

import org.springframework.stereotype.Component;

import com.allianzservice.insuranceproductservice.cisl.model.contractPartiesBody;
import com.allianzservice.insuranceproductservice.cisl.model.contractQuery;

@Component
public class DataMocker {
	
	
	public  Object getMockOfObject(Object obj)
	{
		if(obj instanceof contractQuery)
		{
			return new contractQuery("de_AT","V_KB","http://allianz.com/com.allianz.cisl.core.contract#//Contract");
		}
		else if(obj instanceof contractPartiesBody )
		{
			return new contractPartiesBody("MMAG","","http://allianz.com/com.allianz.cisl.core.person#//Person",
					"MALE","Dqngeov","Ghqyamq","MBA","Kvfrqcx","1984-01-06","429","N","5");
		}
		
		return obj;
	}

}
