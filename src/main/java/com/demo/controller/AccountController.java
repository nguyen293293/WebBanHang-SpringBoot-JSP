package com.demo.controller;

import com.demo.model.Account;
import com.demo.service.AccountService;
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
public class AccountController {

    @Autowired
    AccountService accountService;


    String message;

    @GetMapping("/admin/account")
    public String listAccount(Model model, @RequestParam(value = "p",defaultValue="0")int page){

        Pageable pageable = PageRequest.of(page, 3);
        model.addAttribute("page", accountService.findAll());

        if(message != null){
            model.addAttribute("message", message);
            message = null;
        }
        return "admin/account/list";
    }

    @GetMapping("/admin/account/create")
    public String createAccount(@ModelAttribute("account") Account account, Model model){
        return "admin/account/form";
    }

    @PostMapping("/admin/account/save")
    public String saveAccount(@Valid @ModelAttribute("account") Account account,
                              BindingResult bindingResult, Model model, RedirectAttributes param) {
        System.out.println(account);
        if(bindingResult.hasErrors()){
            account.setUsername("");
            return "admin/account/form";
        }
        accountService.save(account);
        message = "Thêm thành công";
        return "redirect:/admin/account";
    }

    @GetMapping("/admin/account/edit/{id}")
    public String getAccount(@PathVariable String id, Model model) {
        Account account = accountService.findById(id);
        model.addAttribute("account", account);
        return "admin/account/form";
    }

    @PostMapping("/admin/account/update")
    public String updateAccount(@Valid @ModelAttribute("account") Account account,
                                BindingResult bindingResult, Model model) {

        System.out.println(account);
        if(bindingResult.hasErrors()){
            return "admin/account/form";
        }
        message = "Cập nhật thành công";
        accountService.save(account);
        return "redirect:/admin/account";
    }

    @RequestMapping("/admin/account/delete-account/{id}")
    public String deleteAccount(@PathVariable String id) {
        accountService.delete(id);
        message = "Xóa thành công";
        return "redirect:/admin/account";
    }

}
