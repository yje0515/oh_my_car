package com.ohmycar.domain;

import java.util.List;

import lombok.Data;

@Data
public class UserVO {
    private String userId;
    private String userName;
    private String password;
    private String email;
    private String nickName;
    private boolean enabled;
    private List<AuthVO> authList;
}
