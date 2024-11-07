package com.p2.service;

import org.springframework.http.ResponseEntity;

import com.p2.dto.CounselorDto;
import com.p2.dto.LoginRequestDto;

public interface CounselorService {

	ResponseEntity<?> register(CounselorDto counselor);
	
	ResponseEntity<?> login(LoginRequestDto dto);
	
	ResponseEntity<?> update(Integer cid,CounselorDto dto);
	
	ResponseEntity<?> updateStatus(Integer cid,String status);
	
	ResponseEntity<?> updatePhone(Integer cid,Long phone);
	
	ResponseEntity<?> getCouncelor(Integer cid);
	
	ResponseEntity<?> deleteCouncelor(Integer cid);	
}
