package com.example.whiteboardsp19likithponnanna.model;

import java.util.List;

public class Module {
  private Long id;
  private  String title;
  private List<Lesson> lessons;

  public Module() {
  }

  public Module(Long id, String title, List<Lesson> lessons) {
    this.id = id;
    this.title = title;
    this.lessons  = lessons;

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

  public List <Lesson> getLessons() {
    return lessons;
  }

  public void setLessons(List <Lesson> lessons) {
    this.lessons = lessons;
  }
}
