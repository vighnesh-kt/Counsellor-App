package com.p2.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.p2.dao.EnguiryDao;
import com.p2.dto.EnquiryDto;
import com.p2.entity.Enquiry;
import com.p2.enums.ClassMode;
import com.p2.enums.Courses;
import com.p2.exception.EnquiryNotFound;
import com.p2.responsestructure.ResponseStructure;

@Service
public class EnquiryServiceImplementtion implements EnquiryService {

	@Autowired
	private EnguiryDao enquiryDao;

	@Override
	public ResponseEntity<?> add(Enquiry enquiry) {
		Optional<Enquiry>opt=enquiryDao.findByEmail(enquiry.getEmail());
		if(opt.isPresent()) {
			ResponseStructure<String> rs=new ResponseStructure<>();
			rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
			rs.setMessege("Enquiry already exist");
			rs.setData(opt.get().getEmail());
			return new ResponseEntity<>(rs,HttpStatus.OK);
		}
		Enquiry saved =enquiryDao.save(enquiry);
		EnquiryDto dto=new EnquiryDto();
		BeanUtils.copyProperties(saved, dto);
		ResponseStructure<EnquiryDto> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessege("Created Successfully");
		rs.setData(dto);
		return new ResponseEntity<>(rs,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> updateEnquiry(Integer eid,EnquiryDto dto) {
		// TODO Auto-generated method stub
		Enquiry e=enquiryDao.findByEmail(dto.getEmail())
				.orElseThrow(()->new EnquiryNotFound("Enquiry not found"));
		if(dto.getClassMode()!=null) {
			e.setClassMode(dto.getClassMode());
		}
		if(dto.getCourse()!=null) {
			e.setCourse(dto.getCourse());
		}
		if(dto.getEmail()!=null) {
			e.setEmail(dto.getEmail());
		}
		enquiryDao.save(e);
		ResponseStructure<EnquiryDto> rs=new ResponseStructure<>();
		rs.setData(dto);
		rs.setMessege("Enquiry Udated");
		rs.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(rs,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> filterCourse(Courses courses) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> filterClassMode(ClassMode classMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> pagination(Integer pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}


}
