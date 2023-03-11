package com.boots.repository;

import com.boots.entity.Comment;
import com.boots.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface СommentRepository extends JpaRepository<Comment, Long> {
    Comment findByCommentId(int id);
}
