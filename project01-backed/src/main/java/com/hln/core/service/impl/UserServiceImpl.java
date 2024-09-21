package com.hln.core.service.impl;

import cn.hutool.crypto.digest.MD5;
import com.hln.core.mapper.UserMapper;
import com.hln.core.pojo.Users;
import com.hln.core.pojo.bo.UserLoginBo;
import com.hln.core.pojo.vo.ResponseVo;
import com.hln.core.pojo.vo.UserAndTokenVo;
import com.hln.core.service.UserService;
import com.hln.core.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.hln.core.pojo.enums.CodeValues.ERROR_CODE;
import static com.hln.core.pojo.enums.CodeValues.SUCCESS_CODE;
import static com.hln.core.pojo.enums.LoginTypeEnum.EMAIL;
import static com.hln.core.pojo.enums.LoginTypeEnum.MOBILE;
import static com.hln.core.pojo.enums.MessageValues.SUCCESS_MESSAGE;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVo userLogin(UserLoginBo userLoginBo) {

        Users user = null;
        if (userLoginBo.getLoginType().equals(EMAIL))
        {
            user = userMapper.userLogin(userLoginBo);
            if (user == null)
            {
                return ResponseVo.builder()
                        .code(ERROR_CODE)
                        .message("邮箱或密码错误")
                        .build();
            }
        } else if (userLoginBo.getLoginType().equals(MOBILE))
        {
            user = userMapper.userLogin(userLoginBo);
            if (user == null)
            {
                // TODO 验证码校验
                if (!userLoginBo.getMobileCode().equals("123456"))
                {
                    return ResponseVo.builder()
                            .code(ERROR_CODE)
                            .message("验证码错误")
                            .build();
                }
            }
        }

        String token = JwtUtil.createJWT(user);

        return ResponseVo.builder()
                .code(SUCCESS_CODE)
                .data(UserAndTokenVo.builder()
                        .token(token)
                        .build())
                .message(SUCCESS_MESSAGE)
                .build();
    }
}
