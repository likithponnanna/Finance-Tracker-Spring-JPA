package com.example.whiteboardsp19likithponnanna.model;

import java.util.List;

public class User {
  private Long userId;
  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private String role;
  private  String email;
  private String phoneNo;


  public User() {

  }

  public User(Long userId, String username, String password, String firstName, String lastName
          , String role, String email, String phoneNo ) {
    this.userId = userId;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.role = role;
    this.email = email;
    this.phoneNo = phoneNo;

  }

  @Override
  public String toString() {
    return "User{" +
            "userId=" + userId +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", role='" + role + '\'' +
            '}';
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }



  public String getRole() {
    if (role == null) {
      role = "";
    }
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}