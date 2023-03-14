package com.boots.controller;

import com.boots.entity.Comment;
import com.boots.service.CommentService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;
    private Gson gson = new Gson();

    @GetMapping("/comments")
    public ResponseEntity<String> getComments(@RequestParam("video") String videoId){
        Long vidId = 0L;
        try{
            vidId = Long.parseLong(videoId);
        } catch (NumberFormatException e){
            String errorText = "Incorrect video id.";
            return new ResponseEntity<String>(gson.toJson(errorText), HttpStatus.BAD_REQUEST);
        }
        List<Comment> comments = commentService.getAllByVideoId(vidId);
        return new ResponseEntity<String>(gson.toJson(comments), HttpStatus.ACCEPTED);
    }

}
