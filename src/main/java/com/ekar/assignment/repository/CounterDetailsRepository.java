package com.ekar.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekar.assignment.model.CounterDetails;

@Repository
public interface CounterDetailsRepository extends JpaRepository<CounterDetails, Long> {

}
