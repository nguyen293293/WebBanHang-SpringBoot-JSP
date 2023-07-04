package com.demo.repository;

import com.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nguyen293
 * date : 6/6/2023
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

//    @Query(value="SELECT * FROM Product",nativeQuery = true)
//    Page<Product> findAllProductPageable(Pageable pageable);

    @Query(value="SELECT * FROM Product p where p.name LIKE ?1 and p.category.id LIKE ?2 and p.price BETWEEN ?3 and ?4",nativeQuery = true)
    Page<Product> fillter(String keyword, String cateID, Integer minPrice, Integer maxPrice, Pageable pageable);

    Page<Product> findByNameLikeAndCategoryIdLikeAndPriceBetween(String keyword, String cateID, Integer minPrice, Integer maxPrice, Pageable pageable);
}
