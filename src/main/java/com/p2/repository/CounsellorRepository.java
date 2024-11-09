package com.p2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p2.entity.Counsellor;
import java.util.List;
import java.util.Optional;


public interface CounsellorRepository  extends JpaRepository<Counsellor, Integer>{
	
	Optional<Counsellor> findByEmail(String email);

}
