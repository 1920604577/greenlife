package com.hln.core.pojo;

import lombok.*;

import java.util.Date;
import java.io.Serializable;

/**
 * 环保积分兑换表(EcoRewards)实体类
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
public class EcoRewards implements Serializable {
    private static final long serialVersionUID = 685151734810129312L;
    /**
     * 兑换记录ID，主键，自增
     */
    private Long id;
    /**
     * 用户ID，外键
     */
    private Long userId;
    /**
     * 兑换物品，不可为空
     */
    private String rewardItem;
    /**
     * 使用积分数量，不可为空
     */
    private Integer pointsUsed;
    /**
     * 兑换时间，默认为当前时间
     */
    private Date redeemedAt;

}

