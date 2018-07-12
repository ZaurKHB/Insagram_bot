package com.zaurkhb.instagram_bot.controller;

import com.zaurkhb.instagram_bot.services.bot.AutoLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class controller {

    @Autowired
    AutoLikeService autoLikeService;

    @GetMapping("/")
    public String starter() {


        return "index";
    }

    @PostMapping("/liker")
    public void startLiker() {
//        autoLikeService.start("h");

    }
}
