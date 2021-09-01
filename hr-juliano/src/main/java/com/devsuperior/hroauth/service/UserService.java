package com.devsuperior.hroauth.service;

import com.devsuperior.hroauth.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

   private static Logger logger = LoggerFactory.getLogger(UserService.class);

    public User findByEmail(String email){

        return null;
    }
}
