package com.demo.repository;

import com.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nguyen293
 * date : 6/6/2023
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}
