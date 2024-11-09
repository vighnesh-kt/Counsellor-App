package com.p2.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.p2.entity.Counsellor;
import com.p2.repository.CounsellorRepository;

@Repository
public class CounsellorDao {

	@Autowired
	CounsellorRepository counsellorRepository;
	
	public Optional<Counsellor> findByEmail(String email) {
		return counsellorRepository.findByEmail(email);
	}

	public Counsellor save(Counsellor counsellor) {
		return counsellorRepository.save(counsellor);		
	}

	public Optional<Counsellor> findById(Integer cid) {
		// TODO Auto-generated method stub
		return counsellorRepository.findById(cid);
	}
}
