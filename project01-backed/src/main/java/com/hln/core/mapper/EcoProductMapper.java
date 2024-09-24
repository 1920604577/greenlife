package com.hln.core.mapper;

import com.hln.core.pojo.EcoProducts;
import com.hln.core.pojo.bo.DeleteEcoProductBo;
import com.hln.core.pojo.bo.PageEcoProductSBo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    /**
     * 通过产品id查询产品数据
     * @author luyiinn 22/9/2024
     * @param id
     * @return
     */
    EcoProducts selectById(Long id);

    /**
     * 根据环保产品id删除环保产品
     * @author luyiinn 24/9/2024
     * @param deleteEcoProductBo
     * @return
     */
    Long deleteById(DeleteEcoProductBo deleteEcoProductBo);

    /**
     * 环保产品分页查询
     * @author luyiinn 24/9/2024
     * @param pageEcoProductSBo
     * @return
     */
    List<EcoProducts> pageSelect(PageEcoProductSBo pageEcoProductSBo);

    /**
     * 更改环保产品数据
     * @author luyiinn 24/9/2024
     * @param ecoProduct
     * @return
     */
    Long update(EcoProducts ecoProduct);
}
