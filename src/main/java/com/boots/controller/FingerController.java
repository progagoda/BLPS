package com.boots.controller;

import com.boots.entity.Dislikes;
import com.boots.entity.Likes;
import com.boots.service.FingerService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FingerController {

    @Autowired
    private FingerService fingerService;
    private Gson gson = new Gson();

    @PostMapping("/like")
    public ResponseEntity<String> addLike(@RequestParam("videoId") String videoId, @RequestParam("userId") String userId) {
        Long vidId = 0L;
        Long usId = 0L;
        try {
            vidId = Long.parseLong(videoId);
            usId = Long.parseLong(userId);
        } catch (NumberFormatException e) {
            String errorText = "Incorrect video id or userId";
            return new ResponseEntity<String>(gson.toJson(errorText), HttpStatus.BAD_REQUEST);
        }
        Likes like = fingerService.saveLike(vidId, usId);
        return new ResponseEntity<String>(gson.toJson(like), HttpStatus.ACCEPTED);
    }

    @PostMapping("/dislike")
    public ResponseEntity<String> addDisLike(@RequestParam("videoId") String videoId, @RequestParam("userId") String userId) {
        Long vidId = 0L;
        Long usId = 0L;
        try {
            vidId = Long.parseLong(videoId);
            usId = Long.parseLong(userId);
        } catch (NumberFormatException e) {
            String errorText = "Incorrect video id or userId";
            return new ResponseEntity<String>(gson.toJson(errorText), HttpStatus.BAD_REQUEST);
        }
        Dislikes dislike = fingerService.saveDisLike(vidId, usId);
        return new ResponseEntity<String>(gson.toJson(dislike), HttpStatus.ACCEPTED);
    }

}

