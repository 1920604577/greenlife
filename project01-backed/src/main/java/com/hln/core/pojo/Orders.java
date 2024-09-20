package com.hln.core.pojo;

import lombok.*;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单表(Orders)实体类
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
public class Orders implements Serializable {
    private static final long serialVersionUID = 169267511008642614L;
    /**
     * 订单ID，主键，自增
     */
    private Long id;
    /**
     * 用户ID，外键
     */
    private Long userId;
    /**
     * 产品ID，外键
     */
    private Long productId;
    /**
     * 购买数量，不可为空
     */
    private Integer quantity;
    /**
     * 总价，不可为空
     */
    private Double totalPrice;
    /**
     * 订单状态（待处理、已完成、已取消），默认为待处理
     */
    private Object status;
    /**
     * 订单创建时间，默认为当前时间
     */
    private Date orderDate;

}

