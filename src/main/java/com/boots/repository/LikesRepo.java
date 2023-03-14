package com.boots.repository;

import com.boots.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikesRepo  extends JpaRepository<Likes, Long> {
    public List<Likes> findByVideoId(Long videoId);}