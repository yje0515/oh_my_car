package com.ohmycar.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/security-context.xml","file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class UserServiceTests {
    
    @Autowired
    private UserService userService;
    
    @Test
    public void testDelete() {
        String userId = "admin88";
        userService.deleteUser(userId);
        log.info("삭제된 회원 : "+userId);
    }

}
