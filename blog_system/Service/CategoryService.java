package com.example.blog_system.Service;

import com.example.blog_system.ApiResponse.ApiException;
import com.example.blog_system.Model.Category;
import com.example.blog_system.Model.User;
import com.example.blog_system.Repository.CategoryRepository;
import com.example.blog_system.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAll(){
        if(categoryRepository.findAll().isEmpty())throw new ApiException("no category found");
        return categoryRepository.findAll();
    }

    public void add(Category category){
        categoryRepository.save(category);
    }

    public void update(Integer id,Category category){
        Category c=categoryRepository.findCategoryById(id);
        if(c==null)throw new ApiException("no category found with this id");
        c.setName(category.getName());
        categoryRepository.save(c);
    }


    public void delete(Integer id){
        Category c=categoryRepository.findCategoryById(id);
        if(c==null)throw new ApiException("no category found with this id");
        categoryRepository.delete(c);
    }

}
