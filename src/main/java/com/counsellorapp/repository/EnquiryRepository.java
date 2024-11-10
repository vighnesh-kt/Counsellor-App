package com.counsellorapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.counsellorapp.entity.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Integer> {

	Optional<Enquiry>findByEmail(String email);

}
