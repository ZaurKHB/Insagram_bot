package com.zaurkhb.instagram_bot.services.db;

import com.zaurkhb.instagram_bot.model.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AccountServices {

    Account save(Account account);
    boolean delete (int id);
    Optional<Account> getById(int id);
    Account getByUsername(String username);
}
