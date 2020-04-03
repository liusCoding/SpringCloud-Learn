package com.ls.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: order->ResultEnum
 * @description:
 * @author: liushuai
 * @create: 2020-04-03 17:04
 **/
@Getter
@AllArgsConstructor
public enum  ResultEnum {
    PARAM_ERROR(1,"参数有误"),
    CART_EMPTY(2,"购物车为空")
    ;
    private Integer code;
    private String msg;

}
