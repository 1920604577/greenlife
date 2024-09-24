package com.hln.core.pojo.bo;

import lombok.*;

/**
 * 修改环保产品BO
 * @author luyiinn
 * @date 24/9/2024
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class UpdateEcoProductBo {
    private Long id;//产品id
    private String name;//产品名称
    private String description;//产品描述
    private String category;//产品分类
    private Double price;//产品价格
    private Integer stock;//库存数量
}
