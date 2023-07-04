package com.demo.service;

import com.demo.model.Account;
import com.demo.repository.AccountRepository ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accRepo;

    public List<Account> findAll(){
        return accRepo.findAll();
    }

    public Account findById(String id){
        return accRepo.findById(id).get();
    }

    public Account save(Account account){
        return accRepo.save(account);
    }

    public void delete(String id){
        accRepo.deleteById(id);
    }

    public Account checkLogin(String username, String password){
        return accRepo.findAccountByUsernameAndPassword(username, password);
    }
}
