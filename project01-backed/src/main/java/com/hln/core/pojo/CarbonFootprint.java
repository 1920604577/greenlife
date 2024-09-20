package com.hln.core.pojo;

import lombok.*;

import java.util.Date;
import java.io.Serializable;

/**
 * 碳足迹表(CarbonFootprint)实体类
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
public class CarbonFootprint implements Serializable {
    private static final long serialVersionUID = -39539991451522597L;
    /**
     * 碳足迹记录ID，主键，自增
     */
    private Long id;
    /**
     * 用户ID，外键
     */
    private Long userId;
    /**
     * 活动描述，不可为空
     */
    private String activity;
    /**
     * 碳排放量（kg CO2），不可为空
     */
    private Double carbonEmission;
    /**
     * 记录日期，不可为空
     */
    private Date recordDate;
    /**
     * 记录创建时间，默认为当前时间
     */
    private Date createdAt;

}

