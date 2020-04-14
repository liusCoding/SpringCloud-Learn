package com.ls.product.DTO;

import lombok.Data;

/**
 * @program: product->CartDTO
 * @description:
 * @author: liushuai
 * @create: 2020-04-14 15:30
 **/

@Data
public class CartDTO {

    /** 商品id */
    private String productId;

    /** 商品数量 */
    private Integer productQuantity;
}
