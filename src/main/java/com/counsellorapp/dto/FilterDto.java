package com.counsellorapp.dto;

import com.counsellorapp.enums.ClassMode;
import com.counsellorapp.enums.Courses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterDto {

	private ClassMode classMode;
	
	private Courses course;
}