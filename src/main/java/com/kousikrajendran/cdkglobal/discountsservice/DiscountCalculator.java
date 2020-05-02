package com.kousikrajendran.cdkglobal.discountsservice;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kousikrajendran.cdkglobal.beans.Discount;
import com.kousikrajendran.cdkglobal.beans.DiscountCollection;
import com.kousikrajendran.cdkglobal.beans.DiscountSlab;
import com.kousikrajendran.cdkglobal.exceptions.InvalidExecutionException;
import com.kousikrajendran.cdkglobal.exceptions.UnknownCustomerTypeException;
import com.kousikrajendran.cdkglobal.services.ChainOfDiscountSlabs;
import com.kousikrajendran.cdkglobal.services.ChainOfDiscountSlabsBuilder;

/**
 * This is service class, this is used to load discount data from the json file
 * and be ready for calculating discount for given bill amount and customer
 * type;
 * 
 * @author Kousik Rajendran
 *
 */
@Service
@PropertySource(value = "application.properties", ignoreResourceNotFound = true)
public class DiscountCalculator {

	// Collection to be loaded from json from resources folder;
	private DiscountCollection discountCollection;

	/**
	 * Constructor has to load the data from JSON file that is in resources
	 * directory;
	 * 
	 * @throws Exception
	 */
	public DiscountCalculator() throws Exception {
		ClassPathResource cpr = new ClassPathResource("discount-information.json");
		byte[] bData = FileCopyUtils.copyToByteArray(cpr.getInputStream());
		ObjectMapper oMapper = new ObjectMapper();
		this.discountCollection = oMapper.readValue(bData, DiscountCollection.class);
	}

	/**
	 * The method calculates total discount based on the slabs specification; It
	 * takes the total bill amount and customer type to calculate the total
	 * discount.<br/>
	 * <br/>
	 * 
	 * <b>Example:</b><br/>
	 * Discount Slab for Customer Type: "regular"<br/>
	 * Slab 1: $0 - $5,000 is Nil<br/>
	 * Slab 2: $5,000 - $10,000 is 10%<br/>
	 * Slab 3: $10,000 & above is 20%<br/>
	 * <b>Scenario:</b> For purchase of $15,000 by a regular customer would entitle
	 * total discount $1500 which is sum of discount $500 for 2nd slab [10% of
	 * $(10,000 - 5,000)] & $1000 discount for 3rd slab [20% of $(15,000 -
	 * 10,000)]<br/>
	 * 
	 * 
	 * @param customerType
	 * @param billAmount
	 * @return calculated discount
	 * @throws UnknownCustomerTypeException
	 * @throws InvalidExecutionException
	 */
	public long calculateDiscountedBillAmount(String customerType, long billAmount)
			throws UnknownCustomerTypeException, InvalidExecutionException {
		List<Discount> discounts = this.discountCollection.getDiscounts();
		// 1. Check for the customer type and get corresponding object
		Optional<Discount> validDiscountForType = discounts.stream()
				.filter(dis -> customerType.equalsIgnoreCase(dis.getCustomerType())).findFirst();
		if (false == validDiscountForType.isPresent())
			throw new UnknownCustomerTypeException("Customer type not found");
		Discount applicableDiscount = validDiscountForType.get();
		List<DiscountSlab> discountSlabs = applicableDiscount.getSlabs();

		// 2. After getting the corresponding slabs, we are now constructing the Chain
		// of slabs to call the calculation iteratively on all slab objects
		List<ChainOfDiscountSlabs> dsd = ChainOfDiscountSlabsBuilder.getSlabs(discountSlabs, billAmount);

		// 3. Now Initiating the call of calculateDiscount from the first
		// ChainOfDiscountSlabs object, now this will recursively call the next adjacent
		// slab and calculate total applicable discount in the end
		long discountAmount = dsd.get(0).calculateDiscount(0);
		return (billAmount - discountAmount);
	}

}
