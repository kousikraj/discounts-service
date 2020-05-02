package com.kousikrajendran.cdkglobal.services;

import org.springframework.stereotype.Service;

import com.kousikrajendran.cdkglobal.beans.DiscountSlab;
import com.kousikrajendran.cdkglobal.exceptions.InvalidExecutionException;

/**
 * 
 * This is a Chain of Responsibilities Implementation class.
 * 
 * This is an extension of the bean DiscountSlab; This is part of service where
 * we calculate the discount based on the slab rate and pass on the discount to
 * the next slab; Like a chain of events till the last slab is calculated and
 * value is returned;
 * 
 * @author Kousik Rajendran
 *
 */
@Service
public class DiscountSlabDispener implements ChainOfDiscountSlabs {

	private ChainOfDiscountSlabs nextSlab;
	private DiscountSlab discountSlab;
	private long billAmount;

	@Override
	public long calculateDiscount(long discount) throws InvalidExecutionException {
		if (this.discountSlab == null) {
			throw new InvalidExecutionException(
					"The DiscountSlabDispener object is not properly initialized; Make sure discountSlab is set properly");
		}
		long amountFrom = this.getDiscountSlab().getAmountFrom();
		long amountTo = this.getDiscountSlab().getAmountTo();
		long discountPercentage = this.getDiscountSlab().getDiscountPercentage();

		if (this.billAmount > discountSlab.getAmountFrom()) {
			long amountToBeDiscounted = billAmount;
			amountToBeDiscounted = amountToBeDiscounted - amountFrom;
			amountToBeDiscounted = amountToBeDiscounted >= amountTo ? (amountTo - amountFrom) : amountToBeDiscounted;
			discount += (amountToBeDiscounted * discountPercentage) / 100;
			if (this.nextSlab != null) {
				return this.nextSlab.calculateDiscount(discount);
			}
		}
		return discount;
	}

	@Override
	public void setNextSlab(ChainOfDiscountSlabs nextChain) {
		this.nextSlab = nextChain;
	}

	@Override
	public void setBillAmount(long amount) {
		this.billAmount = amount;
	}

	public DiscountSlab getDiscountSlab() {
		return discountSlab;
	}

	public void setDiscountSlab(DiscountSlab discountSlab) {
		this.discountSlab = discountSlab;
	}

	public long getBillAmount() {
		return billAmount;
	}

}
