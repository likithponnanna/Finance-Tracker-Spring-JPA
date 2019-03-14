package com.example.whiteboardsp19likithponnanna.model;

import javax.persistence.Entity;

@Entity
public class ImageWidget extends Widget {
    private String src;

    public ImageWidget(String src) {
        this.src = src;
    }

    public ImageWidget(Long id, String wType, Integer height, Integer width, String src) {
        super(id, wType, height, width);
        this.src = src;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
