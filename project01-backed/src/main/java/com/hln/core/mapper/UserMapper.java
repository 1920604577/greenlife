package com.hln.core.mapper;

import com.hln.core.pojo.Users;
import com.hln.core.pojo.bo.UserLoginBo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    Users userLogin(UserLoginBo userLoginBo);

}
