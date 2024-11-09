package com.p2.service;

import org.springframework.http.ResponseEntity;

import com.p2.dto.EnquiryDto;
import com.p2.entity.Enquiry;
import com.p2.enums.ClassMode;
import com.p2.enums.Courses;

public interface EnquiryService {
	
	ResponseEntity<?> add (Enquiry enquiry);
	
	ResponseEntity<?> updateEnquiry (Integer eid,EnquiryDto enquiry);
	
	ResponseEntity<?> filterCourse(Courses courses);
	
	ResponseEntity<?> filterClassMode(ClassMode classMode);
	
	ResponseEntity<?> pagination(Integer pageNumber);

}
