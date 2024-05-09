package com.ohmycar.domain;

import java.util.List;

import lombok.Data;

@Data
public class UserVO {
 private String userid;
 private String username;
 private String password;
 private String email;
 private String nickname;
 private boolean enabled;
 private List<AuthVO> authList;
}
