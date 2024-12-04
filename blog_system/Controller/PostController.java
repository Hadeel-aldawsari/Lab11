package com.example.blog_system.Controller;

import com.example.blog_system.ApiResponse.ApiResponse;
import com.example.blog_system.Model.Category;
import com.example.blog_system.Model.Post;
import com.example.blog_system.Service.CategoryService;
import com.example.blog_system.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(postService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid Post post, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        postService.add(post);
        return ResponseEntity.status(200).body(new ApiResponse("post added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid Post post, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        postService.update(id,post);
        return ResponseEntity.status(200).body(new ApiResponse("post updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        postService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("post deleted successfully"));
    }

    //1
    @GetMapping("/get-posts/by-userid/{id}")
    public ResponseEntity getAllPostByUser(@PathVariable Integer id){
        return ResponseEntity.status(200).body(postService.getAllPostByUser(id));
    }

//2
    @GetMapping("/get-post/by-title/{title}")
    public ResponseEntity getPostByTitle(@PathVariable String title){
        return ResponseEntity.status(200).body(postService.getPostByTitle(title));
    }
//3
    @GetMapping("/get-posts/before-date/{date}")
    public ResponseEntity getPostsBeforeDate(@PathVariable LocalDate date){
        return ResponseEntity.status(200).body(postService.getPostsBeforeDate(date));
    }

    //4 End point
    @PutMapping("/update-content/{id}")
    public ResponseEntity updateContent(@PathVariable Integer id,@RequestBody String content){

        postService.updateContent(id,content);
        return ResponseEntity.status(200).body(new ApiResponse("post content updated successfully"));
    }

    //5 End Point
    @GetMapping("/get-post/by-category/{id}")
    public ResponseEntity getPostByCategoryId(@PathVariable Integer id){
        return ResponseEntity.status(200).body(postService.getPostByCategoryId(id));
    }






}
