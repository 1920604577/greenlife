package com.hln.core.service;

import com.hln.core.pojo.bo.UserLoginBo;
import com.hln.core.pojo.vo.ResponseVo;

public interface UserService {

    ResponseVo userLogin(UserLoginBo userLoginBo);

}
