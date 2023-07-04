package com.demo.controller;

import com.demo.model.Category;
import com.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author nguyen293
 * date : 6/7/2023
 */

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    String message;

    @GetMapping("/admin/category")
    public String listCategory(Model model, @RequestParam(value = "p",defaultValue="0")int page){

        Pageable pageable = PageRequest.of(page, 3);
        model.addAttribute("page", categoryService.findAll());

        if(message != null){
            model.addAttribute("message", message);
            message = null;
        }
        return "admin/category/list";
    }

    @GetMapping("/admin/category/create")
    public String createCategory(@ModelAttribute("category") Category category, Model model){
        return "admin/category/form";
    }

    @PostMapping("/admin/category/save")
    public String saveCategory(@Valid @ModelAttribute("category") Category category,
                              BindingResult bindingResult, Model model, RedirectAttributes param) {
        System.out.println(category);
        if(bindingResult.hasErrors()){
            category.setId("");
            return "admin/category/form";
        }
        categoryService.save(category);
        message = "Thêm thành công";
        return "redirect:/admin/category";
    }

    @GetMapping("/admin/category/edit/{id}")
    public String getCategory(@PathVariable String id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "admin/category/form";
    }

    @PostMapping("/admin/category/update")
    public String updateCategory(@Valid @ModelAttribute("category") Category category,
                                BindingResult bindingResult, Model model) {

        System.out.println(category);
        if(bindingResult.hasErrors()){
            return "admin/category/form";
        }
        message = "Cập nhật thành công";
        categoryService.save(category);
        return "redirect:/admin/category";
    }

    @RequestMapping("/admin/category/delete-category/{id}")
    public String deleteCategory(@PathVariable String id) {
        categoryService.delete(id);
        message = "Xóa thành công";
        return "redirect:/admin/category";
    }

}
