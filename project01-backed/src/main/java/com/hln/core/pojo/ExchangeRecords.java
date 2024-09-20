package com.hln.core.pojo;

import lombok.*;

import java.util.Date;
import java.io.Serializable;

/**
 * 交易记录表(ExchangeRecords)实体类
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
public class ExchangeRecords implements Serializable {
    private static final long serialVersionUID = -79272939208336888L;
    /**
     * 交易记录ID，主键，自增
     */
    private Long id;
    /**
     * 物品ID，外键
     */
    private Long itemId;
    /**
     * 卖家ID，外键
     */
    private Long sellerId;
    /**
     * 买家ID，外键
     */
    private Long buyerId;
    /**
     * 交易日期
     */
    private Date exchangeDate;
    /**
     * 交易评价
     */
    private String review;
    /**
     * 记录创建时间，默认为当前时间
     */
    private Date createdAt;

}

