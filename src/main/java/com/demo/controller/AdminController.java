package com.demo.controller;

import com.demo.model.Product;
import com.demo.service.AccountService;
import com.demo.service.CategoryService;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {

//    @Autowired
//    ProductService productService;
//
//    @Autowired
//    CategoryService categoryService;
//
//    @Autowired
//    AccountService accountService;

    //  Category
//    @GetMapping("/admin/category/index")
//    public String listCategory(){
//        return "admin/category/list";
//    }
//
//    @GetMapping("/admin/category/create")
//    public String createCategory(){
//        return "admin/category/form";
//    }
//
//    @GetMapping("/admin/category/edit/{id}")
//    public String editCategory(@PathVariable int id){
//        return "admin/category/form";
//    }

    //  Product
//    @GetMapping("/admin/product/index")
//    public String listProduct(Model model){
//        model.addAttribute("listProduct", productService.findAll());
//        return "admin/product/list";
//    }
//
//    @GetMapping("/admin/product/create")
//    public String createProduct(@ModelAttribute("product") Product product, Model model){
//        model.addAttribute("listCategory", categoryService.findAll());
//        return "admin/product/form";
//    }
//
//    @GetMapping("/admin/product/edit/{id}")
//    public String editProduct(@PathVariable int id){
//        return "admin/product/form";
//    }

    //  Account
//    @GetMapping("/admin/account/index")
//    public String listAccount(){
//        return "admin/account/list";
//    }
//
//    @GetMapping("/admin/account/create")
//    public String createAccount(){
//        return "admin/account/form";
//    }
//
//    @GetMapping("/admin/account/edit/{id}")
//    public String editAccount(@PathVariable int id){
//        return "admin/account/form";
//    }
}
