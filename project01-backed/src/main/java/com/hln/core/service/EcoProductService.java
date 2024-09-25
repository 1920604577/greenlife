package com.hln.core.service;

import com.hln.core.pojo.bo.AddEcoProductBo;
import com.hln.core.pojo.vo.ResponseVo;
import org.springframework.stereotype.Service;


public interface EcoProductService {

    /**
     * 新增环保产品
     * @author luyiinn 22/9/2024
     * @param addEcoProductBo
     */
    ResponseVo addEcoProduct(AddEcoProductBo addEcoProductBo);
}
