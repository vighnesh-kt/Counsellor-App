package com.p2.service;

import org.springframework.http.ResponseEntity;

import com.p2.dto.CounsellorDto;
import com.p2.dto.LoginRequestDto;
import com.p2.entity.Counsellor;
import com.p2.enums.Status;

public interface CounsellorService {

	ResponseEntity<?> register(Counsellor counselor);
	
	ResponseEntity<?> login(LoginRequestDto dto);
	
	ResponseEntity<?> update(Integer cid,CounsellorDto dto);
	
	ResponseEntity<?> updateStatus(Integer cid,Status status);
	
	ResponseEntity<?> updatePhone(Integer cid,Long phone);
	
	ResponseEntity<?> getCouncelor(Integer cid);
	
	ResponseEntity<?> deleteCouncelor(Integer cid);	
}
