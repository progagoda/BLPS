package com.boots.service;

import com.boots.entity.Likes;
import com.boots.entity.Dislikes;
import com.boots.repository.CommentRepo;
import com.boots.repository.DislikesRepo;
import com.boots.repository.LikesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FingerService {
    @Autowired
    private LikesRepo likesRepo;
    private DislikesRepo dislikesRepo;

    public Likes getByIdLike(Long id){
        Likes like = likesRepo.findById(id).orElse(null);
        return like;
    }
    public Dislikes getByIdDislike(Long id){
        Dislikes dislike = dislikesRepo.findById(id).orElse(null);
        return dislike;
    }

    public Likes saveLike(Long videoId, Long userId){
        Likes like = new Likes();
        like.setUserId(userId);
        like.setVideoId(videoId);
        return like;
    }
    public Dislikes saveDisLike(Long videoId, Long userId){
        Dislikes dislike = new Dislikes();
        dislike.setUserId(userId);
        dislike.setVideoId(videoId);
        return dislike;
    }



}

