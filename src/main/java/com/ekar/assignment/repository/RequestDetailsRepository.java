package com.ekar.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekar.assignment.model.RequestDetails;

@Repository
public interface RequestDetailsRepository extends JpaRepository<RequestDetails, Long> {

}
