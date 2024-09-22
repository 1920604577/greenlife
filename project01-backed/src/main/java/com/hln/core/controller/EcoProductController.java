package com.hln.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.hln.core.pojo.bo.AddEcoProductBo;
import com.hln.core.pojo.vo.ResponseVo;
import com.hln.core.service.EcoProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.hln.core.pojo.enums.CodeValues.PARAMETER_ERROR;
import static com.hln.core.pojo.enums.MessageValues.PARAMETER_MESSAGE;

@CrossOrigin
@Api(value = "环保产品板块接口",tags = {"环保产品板块接口"})
@RestController
@RequestMapping("/ecoProduct")
@Slf4j
public class EcoProductController {

    @Autowired
    private EcoProductService ecoProductService;

    /**
     * 添加环保产品
     * @author luyiinn 22/9/2024
     * @param addEcoProductBo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("添加环保产品")
    public String addEcoProduct(@RequestBody AddEcoProductBo addEcoProductBo){
        log.info("添加环保产品:{}",addEcoProductBo);
        //参数为空
        if(addEcoProductBo == null){
            JSONArray.toJSONString(
                    ResponseVo.builder()
                            .message(PARAMETER_MESSAGE)
                            .code(PARAMETER_ERROR)
                            .data(null)
                            .build()
            );
        }
        return JSONArray.toJSONString(ecoProductService.addEcoProduct(addEcoProductBo));

    }
}
