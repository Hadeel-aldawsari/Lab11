package com.example.blog_system.Service;


import com.example.blog_system.ApiResponse.ApiException;
import com.example.blog_system.Model.Comment;
import com.example.blog_system.Model.User;
import com.example.blog_system.Repository.CommentRepository;
import com.example.blog_system.Repository.PostRepository;
import com.example.blog_system.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public List<Comment> getAll(){
        if(commentRepository.findAll().isEmpty())throw new ApiException("no comment found");
        return commentRepository.findAll();
    }

    public void add(Comment comment){
        if(userRepository.findUserById(comment.getUserId())==null)
            throw new ApiException("user id not found");

        if(postRepository.findPostById(comment.getPostId())==null)
            throw new ApiException("post id not found");

        comment.setCommentDate(LocalDate.now());
        commentRepository.save(comment);
    }

    public void update(Integer id,Comment comment){
        Comment c=commentRepository.findCommentById(id);
        if(c==null)throw new ApiException("no comment found with this id");

       c.setContent(comment.getContent());
        commentRepository.save(c);

    }


    public void delete(Integer id){
        Comment c=commentRepository.findCommentById(id);
        if(c==null)throw new ApiException("no comment found with this id");
        commentRepository.delete(c);
    }

    //3 End point
    public List<Comment> getCommentsByByPostId(Integer id){
        List<Comment>comments=commentRepository.getCommentsByByPostId(id);
        if(comments.isEmpty())throw new ApiException("there is not comments yet");
        return comments;
    }

}
