package com.ls.order.utils;

import com.ls.order.vo.ResultVo;

/**
 * @program: order->ResultVoUtil
 * @description:
 * @author: liushuai
 * @create: 2020-04-03 17:25
 **/

public class ResultVoUtil {
    public static ResultVo success(Object object){
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(object);
        return resultVo;
    }
}
