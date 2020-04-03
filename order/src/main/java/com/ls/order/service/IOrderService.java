package com.ls.order.service;

import com.ls.order.dto.OrderDTO;

public interface IOrderService{

    /**
     * 创建订单
     * @author liushuai
     * @param orderDTO
     * @return OrderDTO
     */
    OrderDTO create(OrderDTO orderDTO);
}
