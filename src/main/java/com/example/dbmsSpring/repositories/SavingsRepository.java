package com.example.dbmsSpring.repositories;

import com.example.dbmsSpring.model.Saving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SavingsRepository extends JpaRepository<Saving, Long>, JpaSpecificationExecutor<Saving> {

}