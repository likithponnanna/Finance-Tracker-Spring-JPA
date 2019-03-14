package com.example.whiteboardsp19likithponnanna.model;

import javax.persistence.Entity;

@Entity
public class YoutubeWidget extends Widget {
    private String youtubeUrl;

    public YoutubeWidget(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public YoutubeWidget(Long id, String wType, Integer height, Integer width, String youtubeUrl) {
        super(id, wType, height, width);
        this.youtubeUrl = youtubeUrl;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }
}
