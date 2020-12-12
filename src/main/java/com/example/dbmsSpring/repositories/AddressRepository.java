package com.example.dbmsSpring.repositories;

import com.example.dbmsSpring.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AddressRepository extends JpaRepository<Address, String>, JpaSpecificationExecutor<Address> {

}