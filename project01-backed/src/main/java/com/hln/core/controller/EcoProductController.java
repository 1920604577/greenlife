package com.hln.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.hln.core.pojo.bo.AddEcoProductBo;
import com.hln.core.pojo.bo.DeleteEcoProductBo;
import com.hln.core.pojo.bo.PageEcoProductBo;
import com.hln.core.pojo.bo.UpdateEcoProductBo;
import com.hln.core.pojo.vo.ResponseVo;
import com.hln.core.service.EcoProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            return JSONArray.toJSONString(
                    ResponseVo.builder()
                            .message(PARAMETER_MESSAGE)
                            .code(PARAMETER_ERROR)
                            .data(null)
                            .build()
            );
        }
        return JSONArray.toJSONString(ecoProductService.addEcoProduct(addEcoProductBo));

    }

    /**
     * 根据id查询环保产品
     * @author luyiinn 22/9/2024
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询环保产品")
    public String getById(@PathVariable Long id){
        log.info("根据id查询环保产品:{}",id);
        if(id == null){
            return JSONArray.toJSONString(
                    ResponseVo.builder()
                            .message(PARAMETER_MESSAGE)
                            .code(PARAMETER_ERROR)
                            .data(null)
                            .build()
            );
        }
        return JSONArray.toJSONString(ecoProductService.getById(id));
    }

    /**
     * 根据环保产品id删除环保产品
     * @author luyiinn 24/9/2024
     * @return
     */
    @ApiOperation("根据环保产品id删除环保产品")
    @DeleteMapping("/delete")
    public String deleteById(@RequestBody DeleteEcoProductBo deleteEcoProductBo){
        log.info("根据环保产品id删除环保产品:{}",deleteEcoProductBo);
        if(deleteEcoProductBo.getId() == null){
            return JSONArray.toJSONString(
                    ResponseVo.builder()
                            .message(PARAMETER_MESSAGE)
                            .code(PARAMETER_ERROR)
                            .data(null)
                            .build()
            );
        }
        return JSONArray.toJSONString(ecoProductService.deleteById(deleteEcoProductBo));
    }

    /**
     * 环保产品分页查询
     * @author luyiinn 24/9/2024
     * @param pageEcoProductBo
     * @return
     */
    @ApiOperation("环保产品分页查询")
    @PostMapping("/page")
    public String page(@RequestBody PageEcoProductBo pageEcoProductBo){
        log.info("环保产品分类查询:{}",pageEcoProductBo);
        if(pageEcoProductBo == null){
            return JSONArray.toJSONString(
                    ResponseVo.builder()
                            .message(PARAMETER_MESSAGE)
                            .code(PARAMETER_ERROR)
                            .data(null)
                            .build()
            );
        }
        return JSONArray.toJSONString(ecoProductService.page(pageEcoProductBo));
    }

    /**
     * 环保产品修改
     * @author luyiinn 24/9/2024
     * @return
     */
    @ApiOperation("环保产品修改")
    @PutMapping
    public String update(@RequestBody UpdateEcoProductBo updateEcoProductBo){
        log.info("环保产品修改:{}",updateEcoProductBo);
        if(updateEcoProductBo == null){
            return JSONArray.toJSONString(
                    ResponseVo.builder()
                            .message(PARAMETER_MESSAGE)
                            .code(PARAMETER_ERROR)
                            .data(null)
                            .build()
            );
        }
        return JSONArray.toJSONString(ecoProductService.update(updateEcoProductBo));
    }
}
