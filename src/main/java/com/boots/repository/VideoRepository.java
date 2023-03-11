package com.boots.repository;

import com.boots.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VideoRepository extends JpaRepository<Video, Long> {

    Video findById(String id);

}