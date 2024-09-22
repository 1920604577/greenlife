package com.hln.core.service;

import com.alibaba.fastjson2.JSONArray;
import com.hln.core.mapper.EcoProductMapper;
import com.hln.core.pojo.EcoProducts;
import com.hln.core.pojo.bo.AddEcoProductBo;
import com.hln.core.pojo.vo.ResponseVo;
import com.hln.core.util.JwtUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

import static com.hln.core.pojo.enums.CodeValues.*;
import static com.hln.core.pojo.enums.MessageValues.*;

@Service
public class EcoProductServiceImpl implements EcoProductService{

    @Autowired
    private EcoProductMapper ecoProductMapper;

    /**
     * 新增环保产品
     * @param addEcoProductBo
     */
    @Override
    public ResponseVo addEcoProduct(AddEcoProductBo addEcoProductBo) {



        //判断名是否为空
        if(addEcoProductBo.getName() == null){
            return ResponseVo.builder()
                    .message(ERROR_NAME_EMPTY_MESSAGE)
                    .code(PARAMETER_ERROR)
                    .data(null)
                    .build();
        }
        //判断价格是否为空
        if(addEcoProductBo.getPrice() == null){
            return ResponseVo.builder()
                    .message(ERROR_PRICE_EMPTY_MESSAGE)
                    .code(PARAMETER_ERROR)
                    .data(null)
                    .build();
        }

        EcoProducts ecoProduct = new EcoProducts();
        //对象拷贝
        BeanUtils.copyProperties(addEcoProductBo,ecoProduct);

        //添设新增时间和修改时间
        ecoProduct.setCreatedAt(new Date());
        ecoProduct.setUpdatedAt(new Date());

        //设置库存默认值0
        ecoProduct.setStock(0);

        //调用持久层插入数据
        Long along = ecoProductMapper.insert(ecoProduct);

        //插入语句返回null,报错
        if(along == null){
            return ResponseVo.builder()
                    .message(ERROR_MESSAGE)
                    .code(ERROR_CODE)
                    .code(null)
                    .build();
        }

        return ResponseVo.builder()
                .message(SUCCESS_MESSAGE)
                .code(SUCCESS_CODE)
                .data(null)
                .build();
    }

    /**
     * 通过产品id查询产品数据
     * @param id
     * @return
     */
    @Override
    public ResponseVo getById(Long id) {

        EcoProducts ecoProducts = ecoProductMapper.selectById(id);

        return ResponseVo.builder()
                .message(SUCCESS_MESSAGE)
                .code(SUCCESS_CODE)
                .data(ecoProducts)
                .build();
    }


}
