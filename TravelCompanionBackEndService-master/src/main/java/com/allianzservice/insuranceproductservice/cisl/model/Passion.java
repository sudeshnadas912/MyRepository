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

import java.io.Serializable;

public class Passion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uname;
	private String caption;
	private String areaDescrs;
	private String attrDescrs;
	private String fields;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getAreaDescrs() {
		return areaDescrs;
	}

	public void setAreaDescrs(String areaDescrs) {
		this.areaDescrs = areaDescrs;
	}

	public String getAttrDescrs() {
		return attrDescrs;
	}

	public void setAttrDescrs(String attrDescrs) {
		this.attrDescrs = attrDescrs;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

}
