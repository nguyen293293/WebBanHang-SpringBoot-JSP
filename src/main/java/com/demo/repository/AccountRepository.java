package com.demo.repository;

import com.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nguyen293
 * date : 6/6/2023
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    Account findAccountByUsernameAndPassword(String username, String password);
}
