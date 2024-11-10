package com.p2.service;

import org.springframework.http.ResponseEntity;

import com.p2.dto.EnquiryDto;
import com.p2.dto.FilterDto;
import com.p2.entity.Enquiry;

public interface EnquiryService {
	
	ResponseEntity<?> add (Enquiry enquiry,Integer cid);
	
	ResponseEntity<?> updateEnquiry (Integer eid,EnquiryDto enquiry);
	
	ResponseEntity<?> filter(FilterDto dto);
	
	ResponseEntity<?> pagination(Integer pageNumber);

}
