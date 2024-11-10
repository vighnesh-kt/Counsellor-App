package com.counsellorapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.counsellorapp.dto.CounsellorDto;
import com.counsellorapp.dto.LoginRequestDto;
import com.counsellorapp.entity.Counsellor;
import com.counsellorapp.enums.Status;
import com.counsellorapp.service.CounsellorServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/getcounsellor")
	public ResponseEntity<?> getCounsellor(@RequestParam Integer cid) {
		return counsellorService.getCouncelor(cid);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteCounsellor(@RequestParam Integer cid) {
		return counsellorService.deleteCouncelor(cid);
	}
	
	@GetMapping("/findall")
	public ResponseEntity<?> findAll(@RequestParam Integer cid) {
		return counsellorService.findAll(cid);
	}
	
	

}
