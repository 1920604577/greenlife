package com.hln.core.pojo;

import lombok.*;

import java.util.Date;
import java.io.Serializable;

/**
 * 二手物品表(SecondHandItems)实体类
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
public class SecondHandItems implements Serializable {
    private static final long serialVersionUID = 577630482269606931L;

    private Long id;
    /**
     * 发布物品的用户ID，外键
     */
    private Long userId;
    /**
     * 物品标题，不可为空
     */
    private String title;
    /**
     * 物品描述
     */
    private String description;
    /**
     * 物品分类
     */
    private String category;
    /**
     * 物品状态（全新、二手、损坏），不可为空
     */
    private Object itemCondition;
    /**
     * 物品状态（可用、已交换、已删除），默认为可用
     */
    private Object status;
    /**
     * 物品创建时间，默认为当前时间
     */
    private Date createdAt;
    /**
     * 物品更新时间，自动更新
     */
    private Date updatedAt;

}

