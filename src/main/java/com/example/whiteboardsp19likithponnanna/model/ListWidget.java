package com.example.whiteboardsp19likithponnanna.model;

import javax.persistence.Entity;

@Entity
public class ListWidget extends Widget {
    private String[] items;
    private Boolean ordered;

    public ListWidget(String[] items, Boolean ordered) {
        this.items = items;
        this.ordered = ordered;
    }

    public ListWidget(Long id, String wType, Integer height, Integer width, String[] items, Boolean ordered) {
        super(id, wType, height, width);
        this.items = items;
        this.ordered = ordered;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public Boolean getOrdered() {
        return ordered;
    }

    public void setOrdered(Boolean ordered) {
        this.ordered = ordered;
    }
}
