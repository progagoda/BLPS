package com.boots.repository;

import com.boots.entity.Comment;
import com.boots.entity.Dislikes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DislikesRepo extends JpaRepository<Dislikes, Long> {
    public List<Dislikes> findByVideoId(Long videoId);
}
