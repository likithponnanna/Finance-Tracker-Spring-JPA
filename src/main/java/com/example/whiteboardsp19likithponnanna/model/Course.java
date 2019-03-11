package com.example.whiteboardsp19likithponnanna.model;

import java.util.List;

public class Course {
private Long  id;
private  String title;
private User user;
private List<Module> modules;

  public Course() {
  }

  public Course(Long id, String title, User user,  List<Module> modules){
    this.id = id;
    this.title = title;
    this.user = user;
    this.modules = modules;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List <Module> getModules() {
    return modules;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setModules(List <Module> modules) {
    this.modules = modules;
  }
}
