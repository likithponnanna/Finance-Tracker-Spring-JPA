package com.example.whiteboardsp19likithponnanna.model;

import java.util.List;

public class Lesson {
private  Long id;
private  String title;
private List<Topic> topics;

  public Lesson() {
  }

  public Lesson(Long id, String title, List<Topic> topics) {
    this.id = id;
    this.title = title;
    this.topics  = topics;
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

  public List <Topic> getTopics() {
    return topics;
  }

  public void setTopics(List <Topic> topics) {
    this.topics = topics;
  }
}
