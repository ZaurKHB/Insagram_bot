package com.zaurkhb.instagram_bot.controller;

import com.zaurkhb.instagram_bot.model.Account;
import com.zaurkhb.instagram_bot.services.bot.AutoLikeService;
import com.zaurkhb.instagram_bot.services.db.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auto")
public class RestControlServices {

    @Autowired
    AutoLikeService autoLikeService;
    @Autowired
    AccountServices accountServices;


    @PostMapping(value = "like")
    public void startAutoLike(@RequestBody Account account) {

        if (account.getUsername().isEmpty() && account.getPassword().isEmpty())
            return;

        System.out.println(account.toString());
        Account from_db = accountServices.getByUsername(account.getUsername().toLowerCase());

        System.out.println("db " + from_db);

        if (from_db != null)
            if (from_db.getUsername().equalsIgnoreCase(account.getUsername())) {
                System.out.println("This is in db already");
                try {
                    autoLikeService.start(account.getUsername(), account.getPassword());
                } catch (Exception e) {
                    e.getMessage();
                    return;
                }
            }
        accountServices.save(account);

        try {
            autoLikeService.start(account.getUsername(), account.getPassword());
        } catch (Exception e) {
            e.getMessage();
            return;
        }


    }
}
