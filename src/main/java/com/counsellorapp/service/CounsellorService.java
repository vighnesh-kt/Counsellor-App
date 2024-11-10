package com.counsellorapp.service;

import org.springframework.http.ResponseEntity;

import com.counsellorapp.dto.CounsellorDto;
import com.counsellorapp.dto.LoginRequestDto;
import com.counsellorapp.entity.Counsellor;
import com.counsellorapp.enums.Status;

public interface CounsellorService {

	ResponseEntity<?> register(Counsellor counselor);
	
	ResponseEntity<?> login(LoginRequestDto dto);
	
	ResponseEntity<?> update(Integer cid,CounsellorDto dto);
	
	ResponseEntity<?> updateStatus(Integer cid,Status status);
	
	ResponseEntity<?> updatePhone(Integer cid,Long phone);
	
	ResponseEntity<?> getCouncelor(Integer cid);
	
	ResponseEntity<?> deleteCouncelor(Integer cid);	
	
	ResponseEntity<?> findAll(Integer cid);
}
