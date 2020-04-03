package com.ls.order.controller;

import com.ls.order.converter.OrderForm2OrderDTO;
import com.ls.order.dto.OrderDTO;
import com.ls.order.enums.ResultEnum;
import com.ls.order.exception.OrderException;
import com.ls.order.form.OrderForm;
import com.ls.order.service.IOrderService;
import com.ls.order.utils.ResultVoUtil;
import com.ls.order.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: order->OrderController
 * @description:
 * @author: liushuai
 * @create: 2020-04-03 16:38
 **/
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResultVo create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderForm={}",orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }

        //orderForm ->orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>(16);
        map.put("orderId",result.getOrderId());
        return ResultVoUtil.success(map);

    }
}
