package com.estsoft.guestbook.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="guestbook")
public class Guestbook {

	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY )
	private Long no;

	@Column(name="name", nullable=false)
	private String name;

	
	@Column(name="reg_date", nullable=false)
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date regDate;

	@Column(name="passwd", nullable=false, length=32)
	private String password;

	@Column(name="message", nullable=false)
	@Lob
	private String message;
	
	@Column(name="gender", nullable=false)
	@Enumerated(value=EnumType.STRING)
	private Gender gender;
	
	@Transient
	private int temp;
}