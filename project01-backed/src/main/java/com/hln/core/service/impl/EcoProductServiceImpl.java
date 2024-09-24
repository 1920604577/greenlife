package com.hln.core.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.hln.core.mapper.EcoProductMapper;
import com.hln.core.pojo.EcoProducts;
import com.hln.core.pojo.bo.*;
import com.hln.core.pojo.vo.ResponseVo;
import com.hln.core.service.EcoProductService;
import com.hln.core.util.JwtUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static com.hln.core.pojo.enums.CodeValues.*;
import static com.hln.core.pojo.enums.MessageValues.*;

@Service
public class EcoProductServiceImpl implements EcoProductService {

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

    /**
     * 根据环保产品id删除环保产品
     * @param deleteEcoProductBo
     * @return
     */
    @Override
    public ResponseVo deleteById(DeleteEcoProductBo deleteEcoProductBo) {

        Long aLong = ecoProductMapper.deleteById(deleteEcoProductBo);

        //删除语句返回null,报错
        if(aLong == null){
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
     * 环保产品条件分页查询
     * @param pageEcoProductBo
     * @return
     */
    @Override
    public ResponseVo page(PageEcoProductBo pageEcoProductBo) {

        //起始索引计算 起始索引=(查询的页码 - 1) * 每页显示的记录数
        int index = (pageEcoProductBo.getPage()-1)* pageEcoProductBo.getPageSize();

        //将数据存入SBO中,交给持久层
        List<EcoProducts> list = ecoProductMapper.pageSelect(
                PageEcoProductSBo.builder()
                .index(index)
                .pageSize(pageEcoProductBo.getPageSize())
                .name(pageEcoProductBo.getName())
                .category(pageEcoProductBo.getCategory())
                .build()
        );

        return ResponseVo.builder()
                .message(SUCCESS_MESSAGE)
                .code(SUCCESS_CODE)
                .data(list)
                .build();
    }

    /**
     * 环保产品修改
     * @param updateEcoProductBo
     * @return
     */
    @Override
    public ResponseVo update(UpdateEcoProductBo updateEcoProductBo) {

        //判断要修改的环保产品是否存在
        EcoProducts ecoProducts = ecoProductMapper.selectById(updateEcoProductBo.getId());
        if(ecoProducts == null){
            return ResponseVo.builder()
                    .message(ERROR_DATA_NOT_FOUND_MESSAGE)
                    .code(ERROR_CODE)
                    .code(null)
                    .build();
        }

        EcoProducts ecoProduct = new EcoProducts();
        //对象拷贝
        BeanUtils.copyProperties(updateEcoProductBo,ecoProduct);

        //添设修改时间
        ecoProduct.setUpdatedAt(new Date());

        Long aLong = ecoProductMapper.update(ecoProduct);

        //update语句执行失败
        if(aLong == null){
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


}
