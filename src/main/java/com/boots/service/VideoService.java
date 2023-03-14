package com.boots.service;

import com.boots.entity.Video;
import com.boots.repository.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    @Autowired
    private VideoRepo videoRepo;

    public List<Video> getAll(){
        return videoRepo.findAll();
    }

    public Video getById(Long id){
        return videoRepo.findById(id).orElse(null);
    }
}
