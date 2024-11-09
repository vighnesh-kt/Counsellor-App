package com.p2.controller;

import org.springframework.web.bind.annotation.RestController;

import com.p2.dto.CounsellorDto;
import com.p2.dto.LoginRequestDto;
import com.p2.entity.Counsellor;
import com.p2.enums.Status;
import com.p2.service.CounsellorServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/counsellor")
public class CounsellorController {
	
	@Autowired
	CounsellorServiceImplementation counsellorService;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Counsellor counsellor) {
		return counsellorService.register(counsellor);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestDto dto) {
		//TODO: process POST request
		return counsellorService.login(dto);
	}
	
	@PatchMapping("/update/cid/{cid}")
	public ResponseEntity<?> update(@PathVariable Integer cid, @RequestBody CounsellorDto dto) {
		return counsellorService.update(cid, dto);
	}
	
	@PatchMapping("/updatestatus")
	public ResponseEntity<?> updateStatus(@RequestParam Integer cid,@RequestParam Status status){
		return counsellorService.updateStatus(cid, status);
	}
	
	@PatchMapping("/updatephone")
	public ResponseEntity<?>updatePhone(@RequestParam Integer cid,@RequestParam Long phone){
		return counsellorService.updatePhone(cid, phone);
	}

}
