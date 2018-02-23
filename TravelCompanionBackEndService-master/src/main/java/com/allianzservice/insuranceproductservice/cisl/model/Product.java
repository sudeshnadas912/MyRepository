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

import static java.util.stream.Collectors.toList;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String passionSelektorId;
	private String parentId;
	private String prodref;
	private String caption;
	private String fields;
	private String attributes;
	private List<Area> areaList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassionSelektorId() {
		return passionSelektorId;
	}

	public void setPassionSelektorId(String passionSelektorId) {
		this.passionSelektorId = passionSelektorId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getProdref() {
		return prodref;
	}

	public void setProdref(String prodref) {
		this.prodref = prodref;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public List<Area> getAreaList() {
		return areaList.stream().collect(toList());
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList.stream().collect(toList());
	}

}
