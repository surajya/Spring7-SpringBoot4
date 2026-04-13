package com.sp.jobportal.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "contacts")
public class Contact extends BaseEnitity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "email", nullable = false)
	private String email;

	@Lob
	@Column(name = "message", nullable = false)
	private String message;

	@Column(name = "name", nullable = false)
	private String name;

	@ColumnDefault("'NEW'")
	@Column(name = "status", nullable = false, length = 20)
	private String status;

	@Column(name = "subject", nullable = false)
	private String subject;

	@Column(name = "user_type", nullable = false, length = 50)
	private String userType;

}
