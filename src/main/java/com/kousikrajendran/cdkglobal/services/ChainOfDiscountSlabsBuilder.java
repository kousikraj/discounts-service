package com.kousikrajendran.cdkglobal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.kousikrajendran.cdkglobal.beans.DiscountSlab;

/**
 * Builder class to construct Chain of DiscountSlabs from the bean created from
 * JSON data; It constructs using List of
 * com.kousikrajendran.cdkglobal.DiscountSlab bean;
 * 
 * @author Kousik Rajendran
 *
 */
public final class ChainOfDiscountSlabsBuilder {

	/**
	 * 
	 * This method is used to build the list of ChainOfDiscountSlabs using the data
	 * loaded from the json; It consumes list of discountSlabs beans constructed
	 * using the json data and creates the list that will be used for calculating
	 * the discount by using chain of responsibility pattern
	 * 
	 * @param discountSlabs
	 * @param billAmount
	 * @return chainOfDiscountSlabs
	 */
	public static List<ChainOfDiscountSlabs> getSlabs(List<DiscountSlab> discountSlabs, long billAmount) {
		// The sent discount slabs is sorted based on the minimum amount; Just in case
		// the json file provides unsorted list
		discountSlabs = discountSlabs.stream().sorted((s1, s2) -> Long.compare(s1.getAmountFrom(), s2.getAmountFrom()))
				.collect(Collectors.toList());

		// Creating list of DiscountSlab Chains from the bean and json data;
		List<ChainOfDiscountSlabs> cdsList = new ArrayList<ChainOfDiscountSlabs>();
		discountSlabs.forEach(ds -> {
			DiscountSlabDispener dsd = new DiscountSlabDispener();
			dsd.setDiscountSlab(ds);
			dsd.setBillAmount(billAmount);
			dsd.setNextSlab(null);
			cdsList.add(dsd);
		});

		// Setting the nextSlab which is very essential for a chain of responsibility
		// mechanism
		for (int i = 0; i < cdsList.size(); i++) {
			if (i < (cdsList.size() - 1)) {
				cdsList.get(i).setNextSlab(cdsList.get(i + 1));
			}
		}
		return cdsList;
	}

}
