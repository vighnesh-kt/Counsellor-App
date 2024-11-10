package com.p2.dto;

import com.p2.enums.ClassMode;
import com.p2.enums.Courses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterDto {

	private ClassMode classMode;
	
	private Courses course;
}