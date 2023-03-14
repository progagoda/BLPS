package com.boots.repository;

import com.boots.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    public List<Comment> findByVideoId(Long videoId);
}
