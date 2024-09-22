package com.hln.core.service;

import com.hln.core.pojo.bo.AddEcoProductBo;
import com.hln.core.pojo.vo.ResponseVo;
import org.springframework.stereotype.Service;


public interface EcoProductService {


    /**
     * 新增环保产品
     * @author luyiinn 22/9/2024
     * @param addEcoProductBo
     * @return
     */
    ResponseVo addEcoProduct(AddEcoProductBo addEcoProductBo);

    /**
     * 通过产品id查询产品数据
     * @author luyiinn 22/9/2024
     * @param id
     * @return
     */
    ResponseVo getById(Long id);
}
