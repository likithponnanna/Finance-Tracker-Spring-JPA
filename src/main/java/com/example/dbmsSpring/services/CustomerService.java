package com.example.dbmsSpring.services;

import com.example.dbmsSpring.model.AppUser;
import com.example.dbmsSpring.model.Customer;

import com.example.dbmsSpring.model.Trader;
import com.example.dbmsSpring.repositories.AppUserRepository;
import com.example.dbmsSpring.repositories.BankRepository;
import com.example.dbmsSpring.repositories.CustomerRepository;

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
public class CustomerService {

    @Autowired
    AppUserRepository userRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BankRepository bankRepository;


    @GetMapping("/api/customers")
    public List<Customer> findAllCustomers(HttpSession session) {
        return customerRepository.findAll();
    }

    @GetMapping("/api/customers/{id}")
    public Customer findCustomerById(@PathVariable("id") Integer id, HttpSession session) {
        AppUser loggedUser = (AppUser) session.getAttribute("currentUser");
        if(loggedUser!=null) {
            return customerRepository.findById(id).get();
        }
        return new Customer();
    }

    @PostMapping("/api/customers")
    public List<Customer> createCustomer(@RequestBody Customer customer, HttpSession session) {
        AppUser loggedUser = (AppUser) session.getAttribute("currentUser");
        if(session.getAttribute("currentUser")!=null){
            customer.setAppUser(loggedUser);
            customer.setId(loggedUser.getId());
            customer.setBanks(new HashSet<>());

             customerRepository.save(customer);
             return userRepository.findById(loggedUser.getId()).get().getCustomers();
        }

        return new ArrayList<>();
    }


    @PostMapping("/api/customers/{id}")
    public List<Customer> createCustomerMany(@PathVariable("id") Integer id, @RequestBody Customer customer, HttpSession session) {
        AppUser loggedUser = (AppUser) session.getAttribute("currentUser");
        if(session.getAttribute("currentUser")!=null){
            customer.setAppUser(loggedUser);
            customer.setId(loggedUser.getId());
            customer.setBanks(new HashSet<>());

            customerRepository.save(customer);
            return userRepository.findById(loggedUser.getId()).get().getCustomers();
        }

        return new ArrayList<>();
    }




    @DeleteMapping("/api/courses/{id}")
    public boolean deleteCustomer(@PathVariable("id") Integer id, HttpSession session) {
        AppUser loggedUser = (AppUser) session.getAttribute("currentUser");
        if(loggedUser!=null) {

            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/api/courses/{email}")
    public Customer updateCustomer(@PathVariable("email") Integer id, @RequestBody Customer customer, HttpSession session) {
        AppUser loggedUser = (AppUser) session.getAttribute("currentUser");

        if(loggedUser!=null) {
            Customer customerRet = customerRepository.findById(id).get();
            if(customer.getBanks().size()  > 0) {
                customer.setDeactivation(customer.isItDeactivated());
            }
            customer.setBanks(customerRet.getBanks());
            return customerRepository.save(customer);
        }
        return new Customer();
    }





}
