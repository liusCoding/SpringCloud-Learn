package com.ls.product.exception;

import com.ls.product.enums.ResultEnum;
import lombok.Getter;

/**
 * @program: product->ProductException
 * @description:
 * @author: liushuai
 * @create: 2020-04-14 15:36
 **/

@Getter
public class ProductException extends RuntimeException {
    private Integer code;

   public ProductException(Integer code,String msg){
        super(msg);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
