package com.counsellorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.counsellorapp.entity.Counsellor;

import java.util.List;
import java.util.Optional;


public interface CounsellorRepository  extends JpaRepository<Counsellor, Integer>{
	
	Optional<Counsellor> findByEmail(String email);

}
