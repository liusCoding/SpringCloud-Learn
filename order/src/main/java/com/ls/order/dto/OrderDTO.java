package com.ls.order.dto;

import com.ls.order.domain.OrderDetail;
import com.ls.order.enums.OrderStatusEnums;
import com.ls.order.enums.PayStatusEnums;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: order->OrderDTO
 * @description:
 * @author: liushuai
 * @create: 2020-04-03 16:40
 **/
@Data
public class OrderDTO {

    /** 订单ID */
    private String orderId;

    /** 买家姓名 */
    private String buyerName;

    /** 买家手机号 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家微信openid */
    private String buyerOpenid;

    /** 订单总额 */
    private BigDecimal orderAmount;

    /** 订单状态  默认为0新下单*/
    private Integer orderStatus = OrderStatusEnums.NEW.getCode();

    /** 支付状态 默认为0未支付*/
    private Integer payStatus = PayStatusEnums.WAIT.getCode();

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 更新时间 */
    private LocalDateTime updateTime;

    List<OrderDetail> orderDetailList;
}
