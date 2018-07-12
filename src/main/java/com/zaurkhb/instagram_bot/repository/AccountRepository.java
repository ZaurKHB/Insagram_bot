package com.zaurkhb.instagram_bot.repository;

import com.zaurkhb.instagram_bot.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findAccountByUsername(String username);
}
