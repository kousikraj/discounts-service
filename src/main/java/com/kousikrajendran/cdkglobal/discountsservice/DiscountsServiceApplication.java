package com.kousikrajendran.cdkglobal.discountsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscountsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscountsServiceApplication.class, args);
		try {

			DiscountCalculator dc = new DiscountCalculator();
			System.out.println("\n\n**** DISCOUNT CALCULATOR FOR CDC GLOBAL ****\n");
			System.out.println("Discount Calculation for 'Regular' Customer");
			long discount = dc.calculateDiscountedBillAmount("regular", 5000);
			System.out.println("Bill Amount: $5000, Discounted Amount: $" + discount);
			discount = dc.calculateDiscountedBillAmount("regular", 10000);
			System.out.println("Bill Amount: $10,000, Discounted Amount: $" + discount);
			discount = dc.calculateDiscountedBillAmount("regular", 15000);
			System.out.println("Bill Amount: $15,000, Discounted Amount: $" + discount);

			System.out.println("\nDiscount Calculation for 'Premium' Customer");
			discount = dc.calculateDiscountedBillAmount("premium", 4000);
			System.out.println("Bill Amount: $4000, Discounted Amount: $" + discount);
			discount = dc.calculateDiscountedBillAmount("premium", 8000);
			System.out.println("Bill Amount: $8000, Discounted Amount: $" + discount);
			discount = dc.calculateDiscountedBillAmount("premium", 12000);
			System.out.println("Bill Amount: $12,000, Discounted Amount: $" + discount);
			discount = dc.calculateDiscountedBillAmount("premium", 20000);
			System.out.println("Bill Amount: $20,000, Discounted Amount: $" + discount);
			System.out.println("**** End of checking basic test scenarios up ****");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
