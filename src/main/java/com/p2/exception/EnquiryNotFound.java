package com.p2.exception;

public class EnquiryNotFound extends RuntimeException {

	String messege;

	public EnquiryNotFound(String messege) {
		this.messege = messege;
	}
	
	@Override
	public String getMessage() {
		return this.messege;
	}
	

}
