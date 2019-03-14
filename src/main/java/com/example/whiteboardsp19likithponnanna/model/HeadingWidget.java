package com.example.whiteboardsp19likithponnanna.model;

import javax.persistence.Entity;

@Entity
public class HeadingWidget extends Widget {
    private Integer size;

    public HeadingWidget(Integer size) {
        this.size = size;
    }

    public HeadingWidget(Long id, String wType, Integer height, Integer width, Integer size) {
        super(id, wType, height, width);
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
