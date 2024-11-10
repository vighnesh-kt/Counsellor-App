package com.counsellorapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.counsellorapp.dto.EnquiryDto;
import com.counsellorapp.dto.FilterDto;
import com.counsellorapp.entity.Enquiry;
import com.counsellorapp.service.EnquiryServiceImplementtion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/enquiry")
public class EnquiryController {
	
	@Autowired
	private EnquiryServiceImplementtion enquiryService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addEnquiry(@RequestParam Integer cid, @RequestBody Enquiry enquiry) {
		return enquiryService.add(enquiry,cid);
	}
	
	@PatchMapping("/updateenquiry")
	public ResponseEntity<?> updateEnquiry(@RequestParam Integer eid, @RequestBody EnquiryDto enquiry) {
		return enquiryService.updateEnquiry(eid,enquiry);
	}
	
	@GetMapping("/filter")
	public ResponseEntity<?> filter(@RequestBody FilterDto dto) {
		return enquiryService.filter(dto);
	}
	
	@GetMapping("/page")
	public ResponseEntity<?> getPage(@RequestParam Integer pageNumber) {
		return enquiryService.pagination(pageNumber);
	}
	
	
	

}
