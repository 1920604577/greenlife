package com.hln.core.pojo.bo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class UserLoginBo {

    private String email;//邮箱
    private String phone;//手机号
    private String password;//登陆密码
    private String loginType;//登陆状态 (email：邮箱登录, mobile:手机号登录)

}
