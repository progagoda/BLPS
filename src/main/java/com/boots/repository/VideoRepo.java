package com.boots.repository;

import com.boots.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo extends JpaRepository<Video, Long> {
}
