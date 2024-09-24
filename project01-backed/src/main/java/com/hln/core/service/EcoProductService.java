package com.hln.core.service;

import com.hln.core.pojo.bo.AddEcoProductBo;
import com.hln.core.pojo.bo.DeleteEcoProductBo;
import com.hln.core.pojo.bo.PageEcoProductBo;
import com.hln.core.pojo.bo.UpdateEcoProductBo;
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

    /**
     * 根据环保产品id删除环保产品
     * @author luyiinn 24/9/2024
     * @param deleteEcoProductBo
     * @return
     */
    ResponseVo deleteById(DeleteEcoProductBo deleteEcoProductBo);

    /**
     * 环保产品分页查询
     * @author luyiinn 24/9/2024
     * @param pageEcoProductBo
     * @return
     */
    ResponseVo page(PageEcoProductBo pageEcoProductBo);

    /**
     * 环保产品修改
     * @author luyiinn 24/9/2024
     * @param updateEcoProductBo
     * @return
     */
    ResponseVo update(UpdateEcoProductBo updateEcoProductBo);
}
