package com.example.blog_system.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "user name should not be empty")
    @Size(min=5,message = "name Length more than 4")
    @Column(columnDefinition ="varchar(20) not null unique")
    private String username;

    @NotEmpty(message = "password should not be empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()]).{8,20}$", message = "Password must be between 8 and 20 characters long, and include at least one digit, one lowercase letter, one uppercase letter, and one special character (!@#&()).")
    @Column(columnDefinition ="varchar(20) not null")
    private String password;

    @NotEmpty(message = "email should not be empty")
    @Email(message = "enter valid email")
    @Column(columnDefinition ="varchar(30) not null unique")
    private String email;

    @Column(columnDefinition = "timestamp not null default current_timestamp")
    private LocalDate registrationDate;



}
