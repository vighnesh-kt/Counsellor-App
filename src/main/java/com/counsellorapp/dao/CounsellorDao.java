package com.counsellorapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.counsellorapp.entity.Counsellor;
import com.counsellorapp.repository.CounsellorRepository;

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

		return counsellorRepository.findById(cid);
	}

	public List<Counsellor> findAll() {

		return null;
	}

	public boolean remove(Integer cid) {
		if (counsellorRepository.existsById(cid)) { 
			counsellorRepository.deleteById(cid); 
			return true; 
		}
		return false;
	}
}
