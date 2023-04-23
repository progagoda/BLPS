package com.boots.service;

import com.boots.dto.CommentDTO;
import com.boots.entity.Comment;
import com.boots.entity.User;
import com.boots.entity.Video;
import com.boots.exceptions.CommentBodyException;
import com.boots.exceptions.CommentIdException;
import com.boots.exceptions.UserIdException;
import com.boots.exceptions.VideoIdException;
import com.boots.repository.CommentRepo;
import com.boots.repository.UserRepository;
import com.boots.repository.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class CommentService {
   @Autowired
   private CommentRepo commentRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private VideoRepo videoRepo;
    @Resource
    private UserTransaction userTransaction;

   public Comment getById(Long id){
       Comment comment = commentRepo.findById(id).orElse(null);
       return comment;
   }

   public void save(CommentDTO commentDTO) throws SystemException, UserIdException, CommentBodyException, VideoIdException {
      try{
          userTransaction.begin();
          Comment comment = new Comment();
          comment.setVideoId(commentDTO.videoId);
          comment.setAuthorId(commentDTO.userId);
          comment.setText(commentDTO.body);
          if(existsById(comment.getId())){
              log.info("Comment with id {} exist.",comment.getId());
              throw  new CommentIdException("Comment with id {} exist."+ comment.getId());
          }
          if(!existsByVideoId(comment.getVideoId())){
              log.info("Video with id {} hasn't in database",comment.getVideoId());
              throw  new VideoIdException("Video with id {} hasn't in database" + comment.getVideoId());
          }
          if(!checkLengthCommentBody(comment.getText())){
              log.info("Comment with body {} has bad length",comment.getText());
              throw  new CommentBodyException("Comment with body {} has bad length"+comment.getText());

          }
          if(existsByUserName(comment.getAuthorId())){
              log.info("User name with id {} isn't register", comment.getAuthorId());
              throw new UserIdException("User with id {} isn't register"+ comment.getAuthorId());
          }
          userTransaction.commit();
      }
      catch (Exception e){
          if (e instanceof VideoIdException) {
              throw (VideoIdException) e;
          }
              if(e instanceof UserIdException) {
              throw (UserIdException) e;
              } else {
              if (e instanceof CommentBodyException) {
                  throw (CommentBodyException) e;
              }
          }
      }
       if (userTransaction != null) {
           userTransaction.rollback();
       }
   }

   public List<Comment> getAllByVideoId(Long videoId){
       return (List<Comment>) commentRepo.findAll();
   }
    public Boolean existsByUserName(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (!user.isPresent()) {
            log.info("User with id {} not found.", id);
            return false;
        }
        log.info("Found user with id {}.",id);
        return true;
    }

    public Boolean existsById(Long id) {
        Optional<Comment> comment = commentRepo.findById(id);
        if (!comment.isPresent()) {
            log.info("Comment with id {} not found.", id);
            return false;
        }
        log.info("Found user with id {}.", id);
        return true;
    }
    public Boolean existsByVideoId(Long id) {
        Optional<Video> video = videoRepo.findById(id);
        if (!video.isPresent()) {
            log.info("Video with id {} not found.", id);
            return false;
        }
        log.info("Found video with id {}.", id);
        return true;
    }
    public Boolean checkLengthCommentBody(String body) {
        if (body.length()>40) {
            log.info("Comment with body {} is too long.", body);
            return false;
        }
        if (body.length()<5) {
            log.info("Comment with body {} is too short.", body);
            return false;
        }
        log.info("Comment has enough body {}", body);
        return true;
    }
}

