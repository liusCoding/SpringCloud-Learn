package com.ls.order.vo;

import lombok.Data;

/**
 * @program: order->ResultVo
 * @description:
 * @author: liushuai
 * @create: 2020-04-03 17:24
 **/
@Data
public class ResultVo<T> {
    private Integer code;

    private String msg;

    private T data;
}
