package com.p2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.p2.dao.CounsellorDao;
import com.p2.dto.CounsellorDto;
import com.p2.dto.LoginRequestDto;
import com.p2.entity.Counsellor;
import com.p2.enums.Status;
import com.p2.exception.CounsellorNotFound;
import com.p2.responsestructure.ResponseStructure;

@Service
public class CounsellorServiceImplementation implements CounsellorService {

	@Autowired
	private CounsellorDao counsellorDao;

	@Override
	public ResponseEntity<?> register(Counsellor counsellor) {
		Optional<Counsellor> opt = counsellorDao.findByEmail(counsellor.getEmail());
		if (opt.isPresent()) {
			ResponseStructure<String> rs = new ResponseStructure<>();
			rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
			rs.setMessege("Counsellor is Already Registered");
			rs.setData(counsellor.getEmail());

			return new ResponseEntity<>(rs, HttpStatus.OK);
		} else {
			Counsellor savedCounsellor = counsellorDao.save(counsellor);
			CounsellorDto dto = new CounsellorDto();
			BeanUtils.copyProperties(savedCounsellor, dto);

			ResponseStructure<CounsellorDto> rs = new ResponseStructure<>();
			rs.setStatusCode(HttpStatus.CREATED.value());
			rs.setMessege("Counsellor Registered Successfully");
			rs.setData(dto);

			return new ResponseEntity<ResponseStructure<CounsellorDto>>(rs, HttpStatus.OK);
		}

	}

	@Override
	public ResponseEntity<?> login(LoginRequestDto dto) {
		// TODO Auto-generated method stub
		Counsellor c = counsellorDao.findByEmail(dto.getEmail())
				.orElseThrow(() -> new CounsellorNotFound("Counsellor not found"));
		ResponseStructure<String> rs = new ResponseStructure<>();
		if (c.getPassword().equals(dto.getPassword())) {
			rs.setStatusCode(HttpStatus.OK.value());
			rs.setMessege("Login Successfull");
			rs.setData(dto.getEmail());
			return new ResponseEntity<>(rs, HttpStatus.OK);
		}
		rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
		rs.setMessege("Invalid Password");
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<?> update(Integer cid, CounsellorDto dto) {
		Counsellor c = counsellorDao.findById(cid)// when we throw error we dont use optional
				.orElseThrow(() -> new CounsellorNotFound("Counsellor not found"));
		// Manually update fields based on non-null values in the DTO
		if (dto.getName() != null) {
			c.setName(dto.getName());
		}
		if (dto.getEmail() != null) {
			c.setEmail(dto.getEmail());
		}
		if (dto.getPhone() != null) {
			c.setPhone(dto.getPhone());
		}
		if (dto.getPassword() != null) {
			c.setPassword(dto.getPassword());
		}

		counsellorDao.save(c);
		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessege("Updated Successfully");
		rs.setData(dto.getEmail());
		return new ResponseEntity<>(rs, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateStatus(Integer cid, Status status) {
		Counsellor c = counsellorDao.findById(cid).orElseThrow(() -> new CounsellorNotFound("Counsellor Not Found"));
		c.setStatus(status);
		Counsellor saved = counsellorDao.save(c);
		ResponseStructure<Status> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessege("Status Updated");
		rs.setData(saved.getStatus());
		return new ResponseEntity<>(rs, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updatePhone(Integer cid, Long phone) {
		Counsellor c = counsellorDao.findById(cid).orElseThrow(() -> new CounsellorNotFound("Counsellor Not Found"));
		c.setPhone(phone);
		Counsellor saved = counsellorDao.save(c);
		ResponseStructure<Long> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessege("Phone Updated");
		rs.setData(saved.getPhone());
		return new ResponseEntity<>(rs, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getCouncelor(Integer cid) {
		Counsellor c = counsellorDao.findById(cid).orElseThrow(() -> new CounsellorNotFound("Counsellor not found"));
		ResponseStructure<CounsellorDto> rs = new ResponseStructure<>();
		CounsellorDto dto = new CounsellorDto();
		BeanUtils.copyProperties(c, dto);
		rs.setData(dto);
		rs.setMessege("Counsellor Fetched");
		rs.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(rs, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<?> deleteCouncelor(Integer cid) {
		boolean isRemoved = counsellorDao.remove(cid); // Assume remove returns a boolean indicating success/failure

		if (!isRemoved) {
			ResponseStructure<String> rs = new ResponseStructure<>();
			rs.setStatusCode(HttpStatus.NOT_FOUND.value());
			rs.setMessege("Counselor not found");
			return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
		}

		ResponseStructure<Integer> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessege("Counselor Deleted");
		rs.setData(cid);
		return new ResponseEntity<>(rs, HttpStatus.OK);
	}

}
