package com.codeup.springblog.services;

import com.codeup.springblog.models.Users;
import org.springframework.security.core.context.SecurityContextHolder;

public class Utils {
    public static Users currentUser(){
        return (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
