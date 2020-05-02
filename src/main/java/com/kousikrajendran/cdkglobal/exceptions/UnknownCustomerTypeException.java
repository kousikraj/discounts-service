package com.kousikrajendran.cdkglobal.exceptions;

/**
 * This exception is for validating against given set of customer types; If the
 * input is not within available type, we have to throw this exception
 * 
 * @author Kousik Rajendran
 *
 */
public class UnknownCustomerTypeException extends Exception {

	private static final long serialVersionUID = 8732725104093519626L;

	public UnknownCustomerTypeException(String message) {
		super(message);
	}

}
