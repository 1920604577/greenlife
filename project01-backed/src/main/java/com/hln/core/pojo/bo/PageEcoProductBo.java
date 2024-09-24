package com.hln.core.pojo.bo;

import lombok.*;

/**
 * @author luyiinn
 * @date 24/9/2024
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class PageEcoProductBo {

    private int page;//页码
    private int pageSize;//每页记录数
    private String name;//产品名称
    private String category;//产品分类
}
