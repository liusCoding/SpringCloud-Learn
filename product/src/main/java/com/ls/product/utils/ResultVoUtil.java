package com.ls.product.utils;

import com.ls.product.vo.ResultVo;

/**
 * @program: product->ResultVoUtil
 * @description:
 * @author: liushuai
 * @create: 2020-04-03 15:36
 **/

public class ResultVoUtil {

    public static ResultVo success(Object object){

        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setData(object);
        resultVo.setCode(0);
        resultVo.setMsg("成功");

        return resultVo;
    }
}
