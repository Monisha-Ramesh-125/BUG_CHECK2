package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findByCategoryName(String categoryName);

}
