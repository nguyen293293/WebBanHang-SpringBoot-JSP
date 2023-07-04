package com.demo.service;

import com.demo.model.Product;
import com.demo.repository.CategoryRepository;
import com.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    CategoryRepository cateRepo;

    public Page<Product> findAll(Pageable pageable){
        return productRepo.findAll(pageable);
    }

    public List<Product> getAll(){
        return productRepo.findAll();
    }

    public Page<Product> fillter(String keyword, String cateID, Integer minPrice, Integer maxPrice,Pageable pageable) {
        return productRepo.fillter(keyword, cateID, minPrice, maxPrice, pageable);
    }

    public Page<Product> fillter1(String keyword, String cateID, Integer minPrice, Integer maxPrice, Pageable pageable) {
        return productRepo.findByNameLikeAndCategoryIdLikeAndPriceBetween(keyword, cateID, minPrice, maxPrice, pageable);
    }

    public Product findById(Integer id){
        return productRepo.findById(id).get();
    }

    public void save(Product product){
        if(product.getCategory() != null){
            product.setCategory(cateRepo.findById(product.getCategory().getId()).get());
            productRepo.save(product);
        }
    }

    public void delete(Integer id){
        productRepo.deleteById(id);
    }
}
