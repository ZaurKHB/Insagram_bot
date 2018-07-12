package com.zaurkhb.instagram_bot.services.db.impl;

import com.zaurkhb.instagram_bot.model.Account;
import com.zaurkhb.instagram_bot.repository.AccountRepository;
import com.zaurkhb.instagram_bot.services.db.AccountServices;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountServices {

    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(Account account) {

        account.setUsername(account.getUsername().toLowerCase());
        return accountRepository.save(account);
    }

    @Override
    public boolean delete(int id) {
        accountRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<Account> getById(int id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account getByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }
}
