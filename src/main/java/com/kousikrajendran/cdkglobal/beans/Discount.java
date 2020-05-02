package com.kousikrajendran.cdkglobal.beans;

import java.util.List;

/**
 * 
 * This bean is model for loading discount information from JSON or from any web
 * services;
 * 
 * @author Kousik Rajendran
 *
 */
public class Discount {

	private String customerType;
	private String type;
	private List<DiscountSlab> slabs;
	private boolean valid;

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<DiscountSlab> getSlabs() {
		return slabs;
	}

	public void setSlabs(List<DiscountSlab> slabs) {
		this.slabs = slabs;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
