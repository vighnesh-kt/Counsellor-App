package com.counsellorapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.counsellorapp.dao.EnguiryDao;
import com.counsellorapp.dto.EnquiryDto;
import com.counsellorapp.dto.FilterDto;
import com.counsellorapp.entity.Counsellor;
import com.counsellorapp.entity.Enquiry;
import com.counsellorapp.enums.ClassMode;
import com.counsellorapp.enums.Courses;
import com.counsellorapp.exception.CounsellorNotFound;
import com.counsellorapp.exception.EnquiryNotFound;
import com.counsellorapp.repository.CounsellorRepository;
import com.counsellorapp.responsestructure.ResponseStructure;

@Service
public class EnquiryServiceImplementtion implements EnquiryService {

	@Autowired
	private EnguiryDao enquiryDao;
	
	@Autowired
	private CounsellorRepository counsellorRepository;

	@Override
	public ResponseEntity<?> add(Enquiry enquiry,Integer cid) {
		Counsellor counsellor = counsellorRepository.findById(cid)
				.orElseThrow(() -> new CounsellorNotFound("Counsellor Does not exist"));
		Optional<Enquiry>opt=enquiryDao.findByEmail(enquiry.getEmail());
		if(opt.isPresent()) {
			ResponseStructure<String> rs=new ResponseStructure<>();
			rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
			rs.setMessege("Enquiry already exist");
			rs.setData(opt.get().getEmail());
			return new ResponseEntity<>(rs,HttpStatus.OK);
		}
		enquiry.setCounsellor(counsellor);
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
		Enquiry e=enquiryDao.findById(eid)
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
		BeanUtils.copyProperties(e, dto);
		ResponseStructure<EnquiryDto> rs=new ResponseStructure<>();
		rs.setData(dto);
		rs.setMessege("Enquiry Udated");
		rs.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(rs,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> filter(FilterDto dto) {
		Enquiry e =new Enquiry();
		BeanUtils.copyProperties(dto, e);
		
		Example<Enquiry> eg=Example.of(e);//takes entity only
		
		List<Enquiry> all = enquiryDao.findAll(eg);
		
		ResponseStructure<List<Enquiry>> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessege("Retrieved Enquiries");
		rs.setData(all);

		return new ResponseEntity<ResponseStructure<List<Enquiry>>>(rs, HttpStatus.OK);
	}
	

	@Override
	public ResponseEntity<?> pagination(Integer pageNumber) {
		Pageable pageable=PageRequest.of(pageNumber-1,2);
		Page<Enquiry> all=enquiryDao.findAll(pageable);
		
		List<Enquiry> enquiries = all.getContent();	
		  List<EnquiryDto> enquiriesDto = new ArrayList<>();
		    for (Enquiry enquiry : enquiries) {
		        EnquiryDto dto = new EnquiryDto();
		        BeanUtils.copyProperties(enquiry, dto); // Assuming you have a BeanUtils method to copy properties
		        enquiriesDto.add(dto);
		    }
		
		ResponseStructure<List<EnquiryDto>> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessege("Page Retreived");
		rs.setData(enquiriesDto);
		return new ResponseEntity<ResponseStructure<List<EnquiryDto>>>(rs, HttpStatus.OK);
	}


}
