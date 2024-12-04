package com.example.blog_system.Repository;

import com.example.blog_system.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    Post findPostById(Integer id);


    //1 End point
    @Query("select p from Post p where p.userId=?1" )
    List<Post> getAllPostByUser(Integer id);

//2 End point
    Post findPostByTitle(String title);

    //4 End point , get all post before date by date
    List<Post>findPostByPublishDateBefore(LocalDate date);

    //6 End point get post by category
    List<Post>findPostByCategoryId(Integer id);




}
