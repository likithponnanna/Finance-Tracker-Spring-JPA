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
public class AccountService {

    @Autowired
    BankRepository bankRepository;

    @Autowired
    AccountsRepository accountsRepository;


    @GetMapping("/api/accounts")
    public List<Account> findAllAccounts(HttpSession session) {
        return accountsRepository.findAll();
    }

    @GetMapping("/api/accounts/{id}")
    public Account findAccountById(@PathVariable("id") Long id, HttpSession session) {
        AppUser loggedUser = (AppUser) session.getAttribute("currentUser");
        if(loggedUser!=null) {

            return accountsRepository.findById(id).get();

        }
        return new Account();
    }


    @PostMapping("/api/accounts/{mid}")
    public List<Account> createAccount(@PathVariable("mid") Long id,
                                @RequestBody Account account, HttpSession session) {
        AppUser loggedUser = (AppUser) session.getAttribute("currentUser");
        if (loggedUser != null) {


            Account newAccount = new Account();

            newAccount.setAccountId(new Date().getTime());
            newAccount.setAccountName(account.getAccountName());
            newAccount.setBank(account.getBank());
            newAccount.setCheckings(new ArrayList<>());
            newAccount.setSavings(new ArrayList<>());


            Bank banksDa = bankRepository.findById(id).get();


            accountsRepository.save(newAccount);

            return banksDa.getAccounts();
        }

        return new ArrayList<>(Collections.singletonList(new Account()));
    }


    @DeleteMapping("/api/accounts/{aid}")
    public List<Account> deleteLesson(@PathVariable("aid") Long id, HttpSession session) {
        AppUser loggedUser = (AppUser) session.getAttribute("currentUser");
        if(loggedUser!=null) {

            Account dbAccount = accountsRepository.findById(id).get();

            accountsRepository.deleteById(id);

            Bank dbBank = bankRepository.findById(dbAccount.getAccountId()).get();
            return dbBank.getAccounts();


        }

        return new ArrayList<>(Collections.singletonList(new Account()));

    }










}
