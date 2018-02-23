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

public class coverages {
	
	private String classProduct;
	private String self;
	private String classProductSign;
	private selection selection;
	public String getClassProduct() {
		return classProduct;
	}
	public void setClassProduct(String classProduct) {
		this.classProduct = classProduct;
	}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getClassProductSign() {
		return classProductSign;
	}
	public void setClassProductSign(String classProductSign) {
		this.classProductSign = classProductSign;
	}
	public selection getSelection() {
		return selection;
	}
	public void setSelection(selection selection) {
		this.selection = selection;
	}
	
	

}
