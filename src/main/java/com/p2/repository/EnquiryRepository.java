package com.p2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p2.entity.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Integer> {

	Optional<Enquiry>findByEmail(String email);

}
