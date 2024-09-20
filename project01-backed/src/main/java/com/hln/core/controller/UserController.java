package com.hln.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.hln.core.pojo.vo.ResponseVo;
import com.hln.core.pojo.bo.UserLoginBo;
import com.hln.core.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.hln.core.pojo.enums.CodeValues.PARAMETER_ERROR;
import static com.hln.core.pojo.enums.MessageValues.PARAMETER_MESSAGE;

@CrossOrigin
@Api(value = "用户板块接口",tags = {"用户板块接口"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @author hln 2024-9-20
     *      用户登录
     * @param userLoginBo
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public String userLogin(@RequestBody UserLoginBo userLoginBo){
        if(userLoginBo == null){
            JSONArray.toJSONString(
                    ResponseVo.builder()
                            .message(PARAMETER_MESSAGE)
                            .code(PARAMETER_ERROR)
                            .data(null)
                            .build()
            );
        }

        return JSONArray.toJSONString(userService.userLogin(userLoginBo));
    }

}
