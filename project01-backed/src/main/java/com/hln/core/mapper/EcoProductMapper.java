package com.hln.core.mapper;

import com.hln.core.pojo.EcoProducts;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author luyiinn
 * @date 22/9/2024
 */
@Mapper
public interface EcoProductMapper {

    /**
     * 新增环保产品
     * @author luyiinn 22/9/2024
     * @param ecoProduct
     * @return
     */
    Long insert(EcoProducts ecoProduct);
}
