package com.kousikrajendran.cdkglobal.services;

import com.kousikrajendran.cdkglobal.exceptions.InvalidExecutionException;

/**
 * This is the base interface for Chain of responsibility (here discount slab)
 * worker. We shall have to implement this in case we have to add more static
 * and dynamic types of discount slabs.
 * 
 * Discount slab would now be extensible and we can keep adding more types and
 * we don't have to make any change to the calculation mechanism;
 * 
 * Please note that upon initialization of implemented classes, we have to
 * ensure we have set values to next slab, bill amount;
 * 
 * @author Kousik Rajendran
 *
 */
public interface ChainOfDiscountSlabs {

	/**
	 * Used to set the next discount slab;
	 * 
	 * @param nextSlab
	 */
	void setNextSlab(ChainOfDiscountSlabs nextSlab);

	/**
	 * Setting bill amount at the time of
	 * 
	 * @param billAmount
	 */
	void setBillAmount(long amount);

	/**
	 * 
	 * This method is the chain of responsibility implementation. Here we pass on
	 * the the initial discount value or from previous slab; After successful
	 * calculation using the current DiscountSlab, the method will call the next
	 * slab's calculateDiscount() method passing current calculation of the
	 * discount; Finally when no further slab is available, the calculated discount
	 * will be returned to the main thread;
	 * 
	 * @param discount
	 * @return calculated discount
	 */
	long calculateDiscount(long discount) throws InvalidExecutionException;

}
