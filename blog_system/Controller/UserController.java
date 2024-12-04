package com.example.blog_system.Controller;

import com.example.blog_system.ApiResponse.ApiResponse;
import com.example.blog_system.Model.User;
import com.example.blog_system.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService  ;
    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(userService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.add(user);
        return ResponseEntity.status(200).body(new ApiResponse("user added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody @Valid User user,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.update(id,user);
        return ResponseEntity.status(200).body(new ApiResponse("user updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        userService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("user deleted successfully"));
    }

    //6 End point
    @GetMapping("/get-users/registered-today")
    public ResponseEntity getUserRegisteredToday(){
        return ResponseEntity.status(200).body(userService.getUserRegisteredToday());
    }

    //7 End point
    @GetMapping("/get-users/have-no-post")
    public ResponseEntity findUsersWhoHaveNotPosted(){
        return ResponseEntity.status(200).body(userService.findUsersWhoHaveNotPosted());
    }

}
