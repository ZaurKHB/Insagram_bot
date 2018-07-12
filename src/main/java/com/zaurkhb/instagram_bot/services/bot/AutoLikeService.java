package com.zaurkhb.instagram_bot.services.bot;

import org.springframework.stereotype.Service;

@Service
public interface AutoLikeService {

   void start(String username, String password);

}
