package com.in.vm.bloodbank.api.exception;

public class BloodDonorNotFoundException extends Exception{

	/**
	 *Blood donor not found exception 
	 */
	private static final long serialVersionUID = 8677852764512432034L;

	public BloodDonorNotFoundException() {
	
	}
	
	public BloodDonorNotFoundException(String message) {
		super(message);
	}
	
}
