package com.ls.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** 订单状态 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnums implements CodeEnums<Integer> {

    NEW(1,"新订单"),
    FINSH(2,"已完成"),
    CANEL(3,"已取消")
    ;


    private Integer code;

    private String msg;

}
