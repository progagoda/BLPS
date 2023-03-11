package com.boots.entity;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name="t_comment")
public class Comment {
    @Id
    private Long id;// id сообщения
    private int sendler_id; //id  отправителя
    private  int video_id; // id  видео
    private Timestamp timestamp; // время отправления
    private String message; // само сообщение


    public int getSendler_id() {
        return sendler_id;
    }

    public int getVideo_id() {
        return video_id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setSendler_id(int sendler_id) {
        this.sendler_id = sendler_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}


