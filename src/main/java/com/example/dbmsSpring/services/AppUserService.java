package com.example.dbmsSpring.services;

import com.example.dbmsSpring.model.AppUser;

import com.example.dbmsSpring.model.Customer;
import com.example.dbmsSpring.model.Trader;
import com.example.dbmsSpring.repositories.AppUserRepository;

import com.example.dbmsSpring.repositories.CustomerRepository;
import com.example.dbmsSpring.repositories.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;


@RestController
@CrossOrigin(origins = "*", allowCredentials= "true", allowedHeaders ="*")
public class AppUserService {

    @Autowired
    AppUserRepository userRepository;

    @Autowired
    CustomerRepository customerRepository;
//
//    @Autowired
//    TraderRepository traderRepository;


    @GetMapping("/api/users")
    public ArrayList <AppUser> findAllUsers(HttpSession session) {

        return (ArrayList<AppUser>) userRepository.findAll();
    }


    @GetMapping("/api/users/{id}")
    public AppUser findUserById(@PathVariable("id") Integer id,  HttpSession session) {
        return userRepository.findById(id).get();
    }


    @PostMapping("/api/register")
    public AppUser createUser(@RequestBody AppUser user) {



        List<AppUser> usersNa = userRepository.findAll();


        for (AppUser user1 : usersNa) {

            if (user1.getEmail().equals(user.getEmail())) {
                return new AppUser();
            }

        }
        user.setAdmin(false);
        user.setFirstName("");
        user.setLastName("");
        user.setGender("");
        user.setPhoneNo("");
        user.setCustomers(new ArrayList<>());
        user.setTraders(new ArrayList<>());

        return userRepository.save(user);


    }


    @DeleteMapping("/api/delete/{id}")
    public boolean deleteUser(@PathVariable("id") Integer id) {

        AppUser newUser = userRepository.findById(id).get();
        if (newUser.getEmail() != null){
            userRepository.deleteById(id);
            return true;
        }
        return false;


    }

//
//    @PutMapping("/api/update/{email}")
//    public AppUser updateUser(@PathVariable("email") String email, @RequestBody AppUser user) {
//        AppUser dbUser = userRepository.findById(email).get();
//
//        if (dbUser.getEmail().equals(email)) {
//            if (user.getPasswordFl() != null) {
//                dbUser.setPasswordFl(user.getPasswordFl());
//            }
//            if (user.getFirstName() != null) {
//                dbUser.setFirstName(user.getFirstName());
//            }
//            if (user.getLastName() != null) {
//                dbUser.setLastName(user.getLastName());
//            }
//            if (user.getGender() != null) {
//                dbUser.setGender(user.getGender());
//            }
//            if (user.getPhoneNo() != null) {
//                dbUser.setPhoneNo(user.getPhoneNo());
//            }
//
//
//            return userRepository.save(user);
//        }
//
//        return new AppUser();
//    }

    @PostMapping("/api/login")
    public AppUser login(@RequestBody AppUser credentials,
                      HttpSession session) {
        for (AppUser user : userRepository.findAll()) {
            if( user.getEmail().equals(credentials.getEmail())
                    && user.getPasswordFl().equals(credentials.getPasswordFl())) {
                session.setAttribute("currentUser", user);
                return user;
            }
        }
        return new AppUser();
    }

    @PostMapping("/api/logout")
    public void logout
            (HttpSession session) {
        session.removeAttribute("currentUser");
        session.invalidate();
    }

    @GetMapping("/api/profile")
    public AppUser profile(HttpSession session) {
        AppUser currentUser = (AppUser)
                session.getAttribute("currentUser");
        if(currentUser !=null){
            return userRepository.findById(currentUser.getId()).get();
        }
        return new AppUser();
    }





}
