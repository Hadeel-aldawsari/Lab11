package com.example.blog_system.Repository;

import com.example.blog_system.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
   Category findCategoryById(Integer id);

}
