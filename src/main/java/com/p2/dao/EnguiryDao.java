package com.p2.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
