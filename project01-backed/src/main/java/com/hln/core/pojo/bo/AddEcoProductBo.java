package com.hln.core.pojo.bo;

import lombok.*;

/**
 * @author luyiinn
 * @date 22/9/2024
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class AddEcoProductBo {
    private String name;//产品名称
    private String description;//产品描述
    private String category;//产品分类
    private Double price;//产品价格
}
