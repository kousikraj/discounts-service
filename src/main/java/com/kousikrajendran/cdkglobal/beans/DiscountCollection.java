package com.kousikrajendran.cdkglobal.beans;

import java.util.Date;
import java.util.List;

/**
 * This bean is for loading the JSON object form the resources. Later this could
 * be extended to load from an external web service
 * 
 * @author Kousik Rajendran
 *
 */
public class DiscountCollection {

	private String publishedBy;
	private Date updatedOn;
	private String currency;
	private String currencySymbol;
	private String calculationType;
	private List<Discount> discounts;

	public String getPublishedBy() {
		return publishedBy;
	}

	public void setPublishedBy(String publishedBy) {
		this.publishedBy = publishedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public String getCalculationType() {
		return calculationType;
	}

	public void setCalculationType(String calculationType) {
		this.calculationType = calculationType;
	}

	public List<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}

}
