package com.hln.core.pojo;

import lombok.*;

import java.util.Date;
import java.io.Serializable;

/**
 * 环保产品表(EcoProducts)实体类
 *
 * @author makejava
 * @since 2024-09-20 10:42:53
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EcoProducts implements Serializable {
    private static final long serialVersionUID = -89411453441845640L;
    /**
     * 产品ID，主键，自增
     */
    private Long id;
    /**
     * 产品名称，不可为空
     */
    private String name;
    /**
     * 产品描述
     */
    private String description;
    /**
     * 产品分类
     */
    private String category;
    /**
     * 产品价格，不可为空
     */
    private Double price;
    /**
     * 库存数量，默认为0
     */
    private Integer stock;
    /**
     * 产品创建时间，默认为当前时间
     */
    private Date createdAt;
    /**
     * 产品更新时间，自动更新
     */
    private Date updatedAt;

}

