# CDK Global - Discount Calculator Service

Assignment 1: This project is created based on specification document "ShoppingCart-CodingAssignment.pdf".

## Requirements

### Epic Context

A big retail brand outlet, on the eve of Christmas, we want to offer attractive seasonal discounts to our
customers to boost our retail sales.

### Story 1

As a retail outlet’s salesman, I should be able to calculate the customer's shopping cart bill after considering
applicable discount rates that are based on the purchase amount and customer type so that our retail outlet
can maximize sales volume & value.

Refer to the original document for all the scenarios and test case requirements;

## Implementation

I have implemented the Discount Service based on following **assumptions**

1. This should be either independent application or be part of a master application that will consume this as a service
2. The discount slabs and customer types are dynamic; and could change anytime; For eg. we could add customer types such as Gold, Diamond, Platinum etc.

**The implementation is as follows,**

1. The application is a **Spring Boot**; This is used considering the assumption #1.
2. Since the discount slabs are dynamic in nature, I have created **discount-information.json** that has all basic data needed to load the discount slabs based on customer types; Please note that since its JSON, we can easily take data from other services and consume it; Plus the code is totally dynamic and hence can consume any number of slabs and discount for specific customer types; There wont be any limitations for the given conditions
3. I used **Chain of Responsibilities** pattern as I feel that is optimal to have the discount calculated for each slab and pass on to the next slab; This design pattern suits well for the scenario.
4. All classes are commented as needed; That should help to understand the flow of data;

## Installation

Extract the discount-service.zip file and run

```sh
mvn package (or)
mvn test
```

## Exeuction / How to run

1. The application is a standalone one; Wont require any dependency;
2. Run `'mvn package'` for building jar; This will also run the test cases and asserts based on the test results; I have also printed the results in console for easy reference;
3. Run `'mvn test'` for executing test cases to validate the scenarios give in the spec document
4. Run `'java -jar target/discounts-service-0.0.1-SNAPSHOT.jar'` or `' mvn spring-boot:run'` for executing the jar

All the above methods should compile successfully and provide the results of the test scenarios.

### Author

Kousik Rajendran, kousikraj@gmail.com, +91 9900486154
