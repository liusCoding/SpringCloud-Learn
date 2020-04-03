package com.ls.product.vo;

import lombok.Data;

/**
 * @program: product->ResultVo
 * @description:
 * @author: liushuai
 * @create: 2020-04-03 14:56
 **/
@Data
public class ResultVo<T> {

    /** 错误码 */
    private Integer code ;

    /** 提示信息 */
    private String msg;

    /** 返回的具体内容 */
    private T data;
}
