package com.ohmycar.domain;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.ohmycar.service.UserService;

public class UserDAO {
    private UserService userService;

    public UserVO getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userService.getUserByUserId(userDetails.getUsername());
    }
}
