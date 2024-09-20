package com.hln.core.pojo;

import lombok.*;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(Users)实体类
 *
 * @author makejava
 * @since 2024-09-20 10:42:54
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Users implements Serializable {
    private static final long serialVersionUID = -96565395224057049L;

    private Long id;
    /**
     * 用户名，唯一，不可为空
     */
    private String username;
    /**
     * 邮箱，唯一，不可为空
     */
    private String email;
    /**
     * 邮箱，唯一，不可为空
     */
    private String phone;
    /**
     * 用户密码，不可为空
     */
    private String password;
    /**
     * 用户地址
     */
    private String address;
    /**
     * 环保积分，默认值为0
     */
    private Integer ecoScore;
    /**
     * 用户创建时间，默认为当前时间
     */
    private Date createdAt;
    /**
     * 更新时间，每次更新时自动修改
     */
    private Date updatedAt;
    /**
     * 逻辑删除（0：存在，1：删除）
     */
    private Integer delFlag;

}

