package com.demo.service;

import com.demo.model.Category;
import com.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository cateRepo;

    public List<Category> findAll(){
        return cateRepo.findAll();
    }

    public Category findById(String id){
        return cateRepo.findById(id).get();
    }

    public Category save(Category category){
        return cateRepo.save(category);
    }

    public void delete(String id){
        cateRepo.deleteById(id);
    }
}
