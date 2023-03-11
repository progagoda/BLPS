package com.boots.controller;

import com.boots.entity.Comment;
import com.boots.entity.Video;
import com.boots.repository.СommentRepository;
import com.boots.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class AddCommentController {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private СommentRepository commentRepository;

    @PostMapping("/{videoId}")
    public Comment addComment(@PathVariable("videoId") String videoId, @RequestBody Comment comment) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new RuntimeException("Video not found"));
        comment.setVideo(video);
        return commentRepository.save(comment);
    }

}