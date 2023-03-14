package com.boots.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Likes{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long videoId;
    private Long userId;

    public Likes(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVideoId() {
        return videoId;
    }
    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
