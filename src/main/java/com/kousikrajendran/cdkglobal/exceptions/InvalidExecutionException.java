package com.kousikrajendran.cdkglobal.exceptions;

/**
 * This exception is for checking if mandated values for DiscountSlabDispenser
 * is initialized;
 * 
 * @author Kousik Rajendran
 *
 */
public class InvalidExecutionException extends Exception {

	private static final long serialVersionUID = 2333988209301047978L;

	public InvalidExecutionException(String message) {
		super(message);
	}

}
