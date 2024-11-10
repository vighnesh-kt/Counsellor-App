package com.p2.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.p2.dto.EnquiryDto;
import com.p2.entity.Enquiry;
import com.p2.repository.EnquiryRepository;

@Repository
public class EnguiryDao {
	
	@Autowired
	private EnquiryRepository enquiryRepository;
	
	public Enquiry save(Enquiry enquiry) {
		return enquiryRepository.save(enquiry);
	}
	
	public Optional<Enquiry> findByEmail(String email) {
		return enquiryRepository.findByEmail(email);
	}

	public Optional<Enquiry> findById(Integer eid) {
		return enquiryRepository.findById(eid);
	}

	public Page<Enquiry> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return enquiryRepository.findAll(pageable);
	}

	public List<Enquiry> findAll(Example<Enquiry> of) {
		// TODO Auto-generated method stub
		return enquiryRepository.findAll(of);
	}



}
