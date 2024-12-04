package com.example.blog_system.Controller;

import com.example.blog_system.ApiResponse.ApiResponse;
import com.example.blog_system.Model.Comment;
import com.example.blog_system.Model.Post;
import com.example.blog_system.Service.CategoryService;
import com.example.blog_system.Service.CommentService;
import com.example.blog_system.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(commentService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid Comment comment, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        commentService.add(comment);
        return ResponseEntity.status(200).body(new ApiResponse("comment added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid Comment comment, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        commentService.update(id,comment);
        return ResponseEntity.status(200).body(new ApiResponse("comment updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        commentService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("comment deleted successfully"));
    }


    //8d End point
    @GetMapping("/get-comment/by-post/{id}")
    public ResponseEntity getCommentsByByPostId(@PathVariable Integer id){
        return  ResponseEntity.status(200).body( commentService.getCommentsByByPostId(id));
    }

}
