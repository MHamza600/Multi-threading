package com.ekar.assignment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity(name = "RequestRetails")
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "request_details")
public class RequestDetails {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "method_call")
	private String methodCall;

	@Column(name = "url")
	private String url;

	@Column(name = "parameters")
	private String parameters;

	@Column(name = "request_date")
	private Date requestDate;

}
