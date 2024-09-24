package com.hln.core.pojo.bo;

import lombok.*;

/**
 * 用于环保产品分页查询业务层与持久层数据传递
 * @author luyiinn
 * @date 24/9/2024
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class PageEcoProductSBo {
    private int index;//起始索引
    private int pageSize;//每页记录数
    private String name;//产品名称
    private String category;//产品分类
}
