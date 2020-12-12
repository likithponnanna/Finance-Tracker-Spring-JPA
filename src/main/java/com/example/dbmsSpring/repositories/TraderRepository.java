package com.example.dbmsSpring.repositories;

import com.example.dbmsSpring.model.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TraderRepository extends JpaRepository<Trader, Integer>, JpaSpecificationExecutor<Trader> {

}