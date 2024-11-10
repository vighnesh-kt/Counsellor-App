package com.counsellorapp.exception;

public class CounsellorNotFound extends RuntimeException {

	String message;

	public CounsellorNotFound(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
