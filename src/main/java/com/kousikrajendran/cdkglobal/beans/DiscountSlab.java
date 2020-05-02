package com.kousikrajendran.cdkglobal.beans;

/**
 * This bean is for loading discount slab information for any Discount type
 * 
 * @author Kousik Rajendran
 *
 */
public class DiscountSlab {

	private long amountFrom;
	private long amountTo = Long.MAX_VALUE;
	private int discountPercentage;

	public long getAmountFrom() {
		return amountFrom;
	}

	public void setAmountFrom(long amountFrom) {
		this.amountFrom = amountFrom;
	}

	public long getAmountTo() {
		return amountTo;
	}

	public void setAmountTo(long amountTo) {
		this.amountTo = amountTo;
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

}
