package com.kousikrajendran.cdkglobal.discountsservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.kousikrajendran.cdkglobal.exceptions.UnknownCustomerTypeException;

/**
 * The default test class; This is validating all the use-cases as given in the
 * assignment document;
 * 
 * @author Kousik Rajendran
 *
 */
@SpringBootTest
class DiscountsServiceApplicationTests {

	private static DiscountCalculator dc;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before Test..");
		dc = new DiscountCalculator();
	}

	@Test
	void testScenariosFromTheAssignment() {
		try {
			System.out.println("\n\n**** TESTING DISCOUNT CALCULATOR FOR CDC GLOBAL ****\n");

			// Testing for regular customer for given cases;
			System.out.println("Discount Calculation for 'Regular' Customer");
			long discountedBillAmount = dc.calculateDiscountedBillAmount("regular", 5000);
			System.out.println("Bill Amount: $5000, Expected Value: $5000, Actual Value: " + discountedBillAmount);
			assertEquals(5000, discountedBillAmount);
			discountedBillAmount = dc.calculateDiscountedBillAmount("regular", 10000);
			System.out.println("Bill Amount: $10000, Expected Value: $9500, Actual Value: " + discountedBillAmount);
			assertEquals(9500, discountedBillAmount);
			discountedBillAmount = dc.calculateDiscountedBillAmount("regular", 15000);
			System.out.println("Bill Amount: $15000, Expected Value: $13600, Actual Value: " + discountedBillAmount);
			assertEquals(13500, discountedBillAmount);

			// Testing for premium customer for given cases;
			System.out.println("\nDiscount Calculation for 'Premium' Customer");
			discountedBillAmount = dc.calculateDiscountedBillAmount("premium", 4000);
			System.out.println("Bill Amount: $4000, Expected Value: $3600, Actual Value: " + discountedBillAmount);
			assertEquals(3600, discountedBillAmount);
			discountedBillAmount = dc.calculateDiscountedBillAmount("premium", 8000);
			System.out.println("Bill Amount: $8000, Expected Value: $7000, Actual Value: " + discountedBillAmount);
			assertEquals(7000, discountedBillAmount);
			discountedBillAmount = dc.calculateDiscountedBillAmount("premium", 12000);
			System.out.println("Bill Amount: $12000, Expected Value: $10200, Actual Value: " + discountedBillAmount);
			assertEquals(10200, discountedBillAmount);
			discountedBillAmount = dc.calculateDiscountedBillAmount("premium", 20000);
			System.out.println("Bill Amount: $20000, Expected Value: $15800, Actual Value: " + discountedBillAmount);
			assertEquals(15800, discountedBillAmount);
		} catch (UnknownCustomerTypeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterAll
	static void tearDownAfterClass() {
		System.out.println("\n**** End of Testing ****");
	}

}
