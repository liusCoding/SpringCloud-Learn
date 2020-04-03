package com.ls.order.exception;

import com.ls.order.enums.ResultEnum;

/**
 * @program: order->OrderException
 * @description:
 * @author: liushuai
 * @create: 2020-04-03 17:02
 **/

public class OrderException extends RuntimeException {
    private Integer code;

    public OrderException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
