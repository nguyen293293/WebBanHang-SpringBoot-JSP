package com.demo.controller;

import com.demo.model.Product;
import com.demo.service.CategoryService;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @author nguyen293
 * date : 6/7/2023
 */

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    String message;

    @GetMapping("/admin/product")
    public String listProduct(Model model, @RequestParam(value = "p",defaultValue="0")int page){

//        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        Pageable pageable = PageRequest.of(page, 3);
        model.addAttribute("page", productService.findAll(pageable));

        if(message != null){
            model.addAttribute("message", message);
            message = null;
        }
        return "admin/product/list";
    }

    @GetMapping("/admin/product/create")
    public String createProduct(@ModelAttribute("product") Product product, Model model){
        model.addAttribute("listCategory", categoryService.findAll());
        return "admin/product/form";
    }

    @PostMapping("/admin/product/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product,
                              BindingResult bindingResult, Model model, RedirectAttributes param) {
        System.out.println(product);
        if(bindingResult.hasErrors()){
            model.addAttribute("listCategory", categoryService.findAll());
            return "admin/product/form";
        }
        productService.save(product);
        message = "Thêm thành công";
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/edit/{id}")
    public String getProduct(@PathVariable Integer id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("listCategory", categoryService.findAll());
        return "admin/product/form";
    }

    @PostMapping("/admin/product/update")
    public String updateProduct(@Valid @ModelAttribute("product") Product product,
                                BindingResult bindingResult, Model model) {

        System.out.println(product);
        if(bindingResult.hasErrors()){
            model.addAttribute("listCategory", categoryService.findAll());
            return "admin/product/form";
        }
        message = "Cập nhật thành công";
        productService.save(product);
        return "redirect:/admin/product";
    }

    @RequestMapping("/admin/product/delete-product/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.delete(id);
        message = "Xóa thành công";
        return "redirect:/admin/product";
    }

}
