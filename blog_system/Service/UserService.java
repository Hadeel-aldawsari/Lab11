package com.example.blog_system.Service;

import com.example.blog_system.ApiResponse.ApiException;
import com.example.blog_system.Model.User;
import com.example.blog_system.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAll(){
        if(userRepository.findAll().isEmpty())throw new ApiException("no user found");
        return userRepository.findAll();
    }

    public void add(User user){
        user.setRegistrationDate(LocalDate.now());
        userRepository.save(user);
    }

    public void update(Integer id,User user){
        User u=userRepository.findUserById(id);
        if(u==null)throw new ApiException("no user found with this id");

        u.setEmail(user.getEmail());
        u.setUsername(user.getUsername());
        u.setPassword(u.getPassword());
        userRepository.save(u);

    }


    public void delete(Integer id){
        User u=userRepository.findUserById(id);
        if(u==null)throw new ApiException("no user found with this id");

        userRepository.delete(u);
    }

    //7 End point
    public List<User> getUserRegisteredToday(){
        List<User>users=userRepository.findUserByRegistrationDate(LocalDate.now());
        if(users.isEmpty())throw new ApiException("no new user registered today");
        return users;
    }

    //8 End point
    public List<User>findUsersWhoHaveNotPosted(){
        List<User>users=userRepository.findUsersWhoHaveNotPosted();
        if(users.isEmpty())throw new ApiException("all user registered have been posted");

        return users;

    }



}
