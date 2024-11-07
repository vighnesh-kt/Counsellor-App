package com.p2.responsestructure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure<T> {

	private Integer statusCode; 
	
	private String messege;
	
	private T data;
}
