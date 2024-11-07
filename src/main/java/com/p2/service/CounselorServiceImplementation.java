package com.p2.service;

import org.springframework.http.ResponseEntity;

import com.p2.dto.CounselorDto;
import com.p2.dto.LoginRequestDto;

public class CounselorServiceImplementation implements CounselorService{

	@Override
	public ResponseEntity<?> register(CounselorDto counselor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> login(LoginRequestDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> update(Integer cid, CounselorDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateStatus(Integer cid, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updatePhone(Integer cid, Long phone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getCouncelor(Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deleteCouncelor(Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}

}
