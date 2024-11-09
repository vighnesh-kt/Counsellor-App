package com.p2.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.p2.enums.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="counselor_info")
public class Counsellor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cid;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	private Long phone;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status=Status.ACTIVE;
	
	@OneToMany(mappedBy = "counsellor", cascade = CascadeType.ALL )
	private List<Enquiry> enquiry;
	
	@CreationTimestamp
	private LocalDateTime createdDate;

	@UpdateTimestamp
	private LocalDateTime lastUpdate;
}