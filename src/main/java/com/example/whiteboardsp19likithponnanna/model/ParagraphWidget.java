package com.example.whiteboardsp19likithponnanna.model;

import javax.persistence.Entity;

@Entity
public class ParagraphWidget extends Widget {
    private String pText;

    public ParagraphWidget(String pText) {
        this.pText = pText;
    }

    public ParagraphWidget(Long id, String wType, Integer height, Integer width, String pText) {
        super(id, wType, height, width);
        this.pText = pText;
    }

    public String getpText() {
        return pText;
    }

    public void setpText(String pText) {
        this.pText = pText;
    }
}
