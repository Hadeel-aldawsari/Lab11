package com.example.blog_system.Repository;

import com.example.blog_system.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    Comment findCommentById(Integer id);


    //3 End point
    @Query("select c from Comment c where c.postId=?1")
    List<Comment>getCommentsByByPostId(Integer id);
}
