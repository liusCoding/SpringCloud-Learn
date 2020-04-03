package com.ls.order.converter;

import com.alibaba.fastjson.JSON;
import com.ls.order.domain.OrderDetail;
import com.ls.order.dto.OrderDTO;
import com.ls.order.enums.ResultEnum;
import com.ls.order.exception.OrderException;
import com.ls.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @program: order->OrderForm2OrderDTO
 * @description:
 * @author: liushuai
 * @create: 2020-04-03 17:08
 **/
@Slf4j
public class OrderForm2OrderDTO {

    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> detailList;

        try {
               detailList = JSON.parseArray(orderForm.getItems(), OrderDetail.class);
        } catch (Exception e) {
            log.error("【json转换】错误，String={}",orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(detailList);

        return orderDTO;

    }
}
