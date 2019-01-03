package com.in.vm.bloodbank.api.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BloodBankExceptionAdvice {

	@ExceptionHandler(value=BloodDonorNotFoundException.class)
	public ResponseEntity<ErrorResponse> noDonorFoundException(HttpServletRequest request, BloodDonorNotFoundException ex){
		
		ErrorResponse error = new ErrorResponse(ex.getMessage(),request.getRequestURI());
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<ErrorResponse> mapAllExceptions(HttpServletRequest request, Exception ex){
		ErrorResponse error = new ErrorResponse(ex.getMessage(), request.getRequestURI());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
