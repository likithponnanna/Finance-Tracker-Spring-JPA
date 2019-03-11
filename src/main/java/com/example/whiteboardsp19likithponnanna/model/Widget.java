package com.example.whiteboardsp19likithponnanna.model;

public class Widget {
  private Long id;
  private String type;
  private String size;
  private String text;
  private String hName;
  private String pText;
  private String pName;
  private String listType;
  private String items;
  private String lName;
  private String src;
  private String iName;
  private String lText;
  private String href;
  private String linkName;

  public Widget() {
  }

  public Widget(Long id, String type, String size, String text, String hName, String pText, String pName, String listType, String items, String lName, String src, String iName, String lText, String href, String linkName) {
    this.id = id;
    this.type = type;
    this.size = size;
    this.text = text;
    this.hName = hName;
    this.pText = pText;
    this.pName = pName;
    this.listType = listType;
    this.items = items;
    this.lName = lName;
    this.src = src;
    this.iName = iName;
    this.lText = lText;
    this.href = href;
    this.linkName = linkName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String gethName() {
    return hName;
  }

  public void sethName(String hName) {
    this.hName = hName;
  }

  public String getpText() {
    return pText;
  }

  public void setpText(String pText) {
    this.pText = pText;
  }

  public String getpName() {
    return pName;
  }

  public void setpName(String pName) {
    this.pName = pName;
  }

  public String getListType() {
    return listType;
  }

  public void setListType(String listType) {
    this.listType = listType;
  }

  public String getItems() {
    return items;
  }

  public void setItems(String items) {
    this.items = items;
  }

  public String getlName() {
    return lName;
  }

  public void setlName(String lName) {
    this.lName = lName;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public String getiName() {
    return iName;
  }

  public void setiName(String iName) {
    this.iName = iName;
  }

  public String getlText() {
    return lText;
  }

  public void setlText(String lText) {
    this.lText = lText;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public String getLinkName() {
    return linkName;
  }

  public void setLinkName(String linkName) {
    this.linkName = linkName;
  }
}
