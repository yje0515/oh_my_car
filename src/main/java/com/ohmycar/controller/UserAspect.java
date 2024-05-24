package com.ohmycar.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.ohmycar.domain.UserVO;
import com.ohmycar.service.UserService;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
public class UserAspect {

    private final UserService userService;

    public UserAspect(UserService userService) {
        this.userService = userService;
    }

    @Before("execution(* com.ohmycar.controller.*.*(..)) && args(.., userVO)")
    public void setUserVO(JoinPoint joinPoint, UserVO userVO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserVO user = userService.getUserByUserId(userDetails.getUsername());

        log.info("Method name : " + joinPoint.getSignature().getName() + "------------------");
        log.info("Target Object name : " + joinPoint.getTarget().getClass().getName() + "--------------------");

        userVO.setAuthList(user.getAuthList());
        userVO.setEmail(user.getEmail());
        userVO.setEnabled(user.isEnabled());
        userVO.setNickName(user.getNickName());
        userVO.setPassword(user.getPassword());
        userVO.setUserId(user.getUserId());
        userVO.setUserName(user.getUserName());
    }
}
