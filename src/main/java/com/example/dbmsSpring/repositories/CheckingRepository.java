package com.example.dbmsSpring.repositories;

import com.example.dbmsSpring.model.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CheckingRepository extends JpaRepository<Checking, Long>, JpaSpecificationExecutor<Checking> {

}