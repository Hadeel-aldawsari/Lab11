package com.example.blog_system.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "user name should not be empty")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Name should contain letters and spaces only")
    @Column(columnDefinition = "varchar(40) not null")
    private String name;
}
