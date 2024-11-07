package com.p2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="enquiry_info")
@Data
public class Enquiry {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer eid;
	
	private String name;
	
	@Column(unique = true,nullable = false)
	private String email;
	
	private Long phone;
	
	@Enumerated(EnumType.STRING)
	private String course;
	
	@Enumerated(EnumType.STRING)
	private String classMode;
	
	private Integer fees;

	@ManyToOne()
	@JoinColumn(name = "cid")
	private Counselor counselor;
}
