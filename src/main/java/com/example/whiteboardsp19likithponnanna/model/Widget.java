package com.example.whiteboardsp19likithponnanna.model;

import javax.persistence.criteria.CriteriaBuilder;

public class Widget {
  private Long id;
  private String wType;
  private Integer height;
  private Integer width;


  public Widget() {
  }

  public Widget(Long id, String wType, Integer height, Integer width) {
    this.id = id;
    this.wType = wType;
    this.height = height;
    this.width = width;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getwType() {
    return wType;
  }

  public void setwType(String wType) {
    this.wType = wType;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }
}
