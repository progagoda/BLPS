package com.boots.controller;


import com.boots.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class VideoController {

    @Autowired
    private StreamingService service;

    @GetMapping(value = "video/{id}", produces = "video/mp4")
    public Mono<Resource> getVideos(@PathVariable Long id, @RequestHeader("Range") String range){
        return service.getVideo(id);
    }
}
