package com.p2.controller;

import org.springframework.web.bind.annotation.RestController;

import com.p2.dto.EnquiryDto;
import com.p2.entity.Enquiry;
import com.p2.service.EnquiryServiceImplementtion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/enquiry")
public class EnquiryController {
	
	@Autowired
	private EnquiryServiceImplementtion enquiryService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addEnquiry(@RequestBody Enquiry enquiry) {
		return enquiryService.add(enquiry);
	}
	
	@PatchMapping("/updateenquiry")
	public ResponseEntity<?> postMethodName(@RequestParam Integer eid, @RequestBody EnquiryDto enquiry) {
		return enquiryService.updateEnquiry(enquiry);
	}
	
	

}
