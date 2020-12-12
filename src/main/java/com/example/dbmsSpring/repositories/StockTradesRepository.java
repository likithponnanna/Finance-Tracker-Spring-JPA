package com.example.dbmsSpring.repositories;

import com.example.dbmsSpring.model.StockTrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StockTradesRepository extends JpaRepository<StockTrade, Integer>, JpaSpecificationExecutor<StockTrade> {

}