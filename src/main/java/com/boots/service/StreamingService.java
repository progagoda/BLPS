package com.boots.service;

import com.boots.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StreamingService {

    private static final String FORMAT = "classpath:videos/%s.mp4";
    private ResourceLoader resourceLoader;
    @Autowired
    private VideoService videoService;

    public Mono<Resource> getVideo(Long id){
        Video video = videoService.getById(id);
        String title = video.getTitle();
        return Mono.fromSupplier(() -> resourceLoader.getResource(String.format(FORMAT, title)));
    }

}
