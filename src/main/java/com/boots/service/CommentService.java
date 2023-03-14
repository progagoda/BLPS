package com.boots.service;

import com.boots.entity.Comment;
import com.boots.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
   @Autowired
   private CommentRepo commentRepo;

   public Comment getById(Long id){
       Comment comment = commentRepo.findById(id).orElse(null);
       return comment;
   }

   public void save(Comment comment){
       commentRepo.save(comment);
   }

   public List<Comment> getAllByVideoId(Long videoId){
       return commentRepo.findAll();
   }

}
