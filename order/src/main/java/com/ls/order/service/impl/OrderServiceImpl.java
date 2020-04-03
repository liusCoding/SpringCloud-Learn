package com.ls.order.service.impl;

import com.ls.order.dto.OrderDTO;
import com.ls.order.repository.OrderMasterRepository;
import com.ls.order.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * @program: order->OrderServiceImpl
 * @description:
 * @author: liushuai
 * @create: 2020-04-03 16:43
 **/
@Service
public class OrderServiceImpl implements IOrderService {

    private final OrderMasterRepository orderMasterRepository;

    public OrderServiceImpl(OrderMasterRepository orderMasterRepository) {
        this.orderMasterRepository = orderMasterRepository;
    }

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return OrderDTO
     * @author liushuai
     */
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        //TODO  查询商品信息（调用商品服务）
        //TODO  计算总价
        //TODO  扣库存（调用商品服务）
        //TODO  订单入库
        return null;
    }
}
