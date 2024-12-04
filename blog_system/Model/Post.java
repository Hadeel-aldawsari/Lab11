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

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "category_id  not null")
    @Positive(message = "category_id  should be positive number")
    @Column(columnDefinition = "int not null")
    private Integer categoryId;

    @NotEmpty(message = "title should not be null")
    @Column(columnDefinition = "varchar(50) not null")
    private String title;

    @NotEmpty(message = "content should not be empty")
    @Size(min=30,message = "content length should be 30 character or more")
    @Column(columnDefinition = "varchar(1000) not null")
    private String content;

    @NotNull(message = "user_id  not null")
    @Positive(message = "user_id  should be positive number")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @Column(columnDefinition = "timestamp not null default current_timestamp")
    private LocalDate publishDate;

    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDate LastUpdate;


}
