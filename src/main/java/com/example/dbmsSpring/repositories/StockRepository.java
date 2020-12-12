package com.example.dbmsSpring.repositories;

import com.example.dbmsSpring.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StockRepository extends JpaRepository<Stock, String>, JpaSpecificationExecutor<Stock> {

}