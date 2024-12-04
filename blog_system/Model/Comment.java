package com.example.blog_system.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "user_id  not null")
    @Positive(message = "user_id  should be positive number")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @NotNull(message = "post_id  not null")
    @Positive(message = "post_id  should be positive number")
    @Column(columnDefinition = "int not null")
    private Integer postId;

    @NotEmpty(message = "content should not be empty")
    @Size(min=3,message = "content length should be 3 character or more")
    @Column(columnDefinition = "varchar(100) not null")
    private String content;

    @Column(columnDefinition = "timestamp not null default current_timestamp")
    private LocalDate commentDate;



}
