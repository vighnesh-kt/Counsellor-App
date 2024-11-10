package com.counsellorapp.service;

import org.springframework.http.ResponseEntity;

import com.counsellorapp.dto.EnquiryDto;
import com.counsellorapp.dto.FilterDto;
import com.counsellorapp.entity.Enquiry;

public interface EnquiryService {
	
	ResponseEntity<?> add (Enquiry enquiry,Integer cid);
	
	ResponseEntity<?> updateEnquiry (Integer eid,EnquiryDto enquiry);
	
	ResponseEntity<?> filter(FilterDto dto);
	
	ResponseEntity<?> pagination(Integer pageNumber);

}
