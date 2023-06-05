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

@Entity(name = "CounterDetails")
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "counter_details")
public class CounterDetails {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "thread_name")
	private String threadName;

	@Column(name = "thread_value")
	private Integer threadValue;

	@Column(name = "request_time")
	private Date requestTime;

}
