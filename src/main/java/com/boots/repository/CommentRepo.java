package com.boots.repository;

import com.boots.entity.Comment;
import com.boots.entity.User;
import com.boots.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepo extends CrudRepository<Comment, Long> {
    Comment findCommentById(Long id);
}
