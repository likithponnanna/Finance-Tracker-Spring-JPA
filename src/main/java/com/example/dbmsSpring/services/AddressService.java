package com.example.dbmsSpring.services;

import com.example.dbmsSpring.model.Address;
import com.example.dbmsSpring.model.AppUser;
import com.example.dbmsSpring.model.Customer;
import com.example.dbmsSpring.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import javax.servlet.http.HttpSession;


@RestController
@CrossOrigin(origins = "*", allowCredentials= "true", allowedHeaders ="*")
public class AddressService{

    @Autowired
    AddressRepository addressRepository;


    @GetMapping("/api/address")
    public List<Address> findAllAddresses(HttpSession session) {

        return  addressRepository.findAll();
    }

    @GetMapping("/api/address/{zip}")
    public Address findAddressById(@PathVariable("zip") String id, HttpSession session) {
        AppUser loggedUser = (AppUser) session.getAttribute("currentUser");
        if(loggedUser!=null) {
            return addressRepository.findById(id).get();
        }
        return new Address();
    }

    @PostMapping("/api/address/{zip}")
    public Address createAddress(@PathVariable("zip") String zip , @RequestBody Address address) {
        return addressRepository.save(address);

    }

    @DeleteMapping("/api/address/{zip}")
    public void deleteUser(@PathVariable("zip") String zip) {
          addressRepository.deleteById(zip);
    }


}
