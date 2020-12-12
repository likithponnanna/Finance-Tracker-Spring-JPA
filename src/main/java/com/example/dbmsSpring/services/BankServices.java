package com.example.dbmsSpring.services;

import com.example.dbmsSpring.model.*;


import com.example.dbmsSpring.repositories.*;


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
public class BankServices {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BankRepository bankRepository;

    @GetMapping("/api/banks")
    public List<Bank> findAllBanks( HttpSession session) {
        AppUser loggedUser = (AppUser) session.getAttribute("currentUser");
        if(loggedUser!=null) {
            //Customer customersDa = customerRepository.findById(id).get();
            return bankRepository.findAll();
        }
        return new ArrayList<>(Collections.singletonList(new Bank())) ;
    }



    @GetMapping("/api/customer/{cid}/banks")
    public Set<Bank> findAllBanks(@PathVariable("cid") Integer id, HttpSession session) {
        AppUser loggedUser = (AppUser) session.getAttribute("currentUser");
        if(loggedUser!=null) {
            Customer customersDa = customerRepository.findById(id).get();
            return customersDa.getBanks();
        }
        return new HashSet<>(Collections.singletonList(new Bank())) ;
    }

    @GetMapping("/api/bank/{bid}")
    public Bank findBankById(@PathVariable("bid") Long id, HttpSession session) {
        AppUser loggedUser = (AppUser) session.getAttribute("currentUser");
        if(loggedUser!=null) {
            return bankRepository.findById(id).get();
        }
        return new Bank();
    }


    @PostMapping("/api/customer/{cid}/banks")
    public Bank createBank(@PathVariable("cid") Integer id,
                                     @RequestBody Bank bank, HttpSession session) {
        AppUser loggedUser = (AppUser) session.getAttribute("currentUser");
        if(loggedUser!=null) {


            Bank newBank = new Bank();

            newBank.setBankID(new Date().getTime());


            Customer customersDa = customerRepository.findById(id).get();
            //lesson.setModule(customersDa);
            Set<Customer> newCustomerList = new  HashSet<>();
            newCustomerList.add(customersDa);



            newBank.setAccounts(new ArrayList<>());
            newBank.setLoans(new ArrayList<>());
            newBank.setCreditCards(new ArrayList<>());
            if(!bank.isBranchType())
            {
                newBank.setBranchType(false);
            }
            if(bank.getAddress() == null || bank.getAddress().getZipcode() == null)
            {
                newBank.setAddress(null);
            }else {
                newBank.setAddress(bank.getAddress());
            }
            if(bank.getBankName()== null || bank.getBankName().equals(""))
            {
                newBank.setBankName("New Bank");
            }else {
                newBank.setBankName(bank.getBankName());
            }



            newBank.setCustomers(newCustomerList);


            Bank test = bankRepository.save(newBank);

            return test;
        }

        return new Bank();

    }


    @DeleteMapping("/api/bank/{bid}")
    public Set<Bank> deleteLesson(@PathVariable("bid") Long id, HttpSession session) {
        AppUser loggedUser = (AppUser) session.getAttribute("currentUser");
        if(loggedUser!=null) {

            Bank dbBank = bankRepository.findById(id).get();

            bankRepository.deleteById(id);
            Customer dbCustomer = customerRepository.findById(Math.toIntExact(dbBank.getBankID())).get();
            return dbCustomer.getBanks();


        }

        return new HashSet<>(Arrays.asList(new Bank()));

    }


    @PutMapping("/api/bank/{bid}")
    public Set<Bank> updateLesson(@PathVariable("bid") Long id, @RequestBody Bank bank, HttpSession session) {
        AppUser loggedUser = (AppUser) session.getAttribute("currentUser");

        if (loggedUser != null) {
            Bank dbBank = bankRepository.findById(id).get();
            dbBank.setLoans(bank.getLoans());
            dbBank.setAddress(bank.getAddress());
            dbBank.setBranchType(bank.isBranchType());
            dbBank.setCreditCards(bank.getCreditCards());
            dbBank.setAccounts(bank.getAccounts());
            dbBank.setBankName(bank.getBankName());

            bankRepository.save(dbBank);

            Customer dbCustomer = customerRepository.findById(Math.toIntExact(dbBank.getBankID())).get();
            return dbCustomer.getBanks();


        }
        return new HashSet<>(Arrays.asList(new Bank()));
    }






}
