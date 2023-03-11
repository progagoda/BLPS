package com.boots.service;

import com.boots.entity.Comment;
import com.boots.entity.Video;
import com.boots.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddCommentService {

    @Autowired
    private VideoRepository videoRepository;

    public void addCommentToVideo(String videoId, Comment comment) {
        Video video = videoRepository.findById(videoId);
        if (video == null) {
            throw new IllegalArgumentException("Video with id " + videoId + " not found.");
        }
        video.addComment(comment);
        videoRepository.save(video);
    }

    public void deleteCommentFromVideo(String videoId, String commentId) {
        Video video = videoRepository.findById(videoId);
        if (video == null) {
            throw new IllegalArgumentException("Video with id " + videoId + " not found.");
        }
        Comment comment = video.getCommentById(commentId);
        if (comment == null) {
            throw new IllegalArgumentException("Comment with id " + commentId + " not found.");
        }
        video.deleteComment(comment);
        videoRepository.save(video);
    }

    public void updateCommentOnVideo(String videoId, String commentId, String newContent) {
        Video video = videoRepository.findById(videoId);
        if (video == null) {
            throw new IllegalArgumentException("Video with id " + videoId + " not found.");
        }
        Comment comment = video.getCommentById(commentId);
        if (comment == null) {
            throw new IllegalArgumentException("Comment with id " + commentId + " not found.");
        }
        comment.setText(newContent);
        videoRepository.save(video);
    }

}