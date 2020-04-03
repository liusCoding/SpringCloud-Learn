package com.ls.order.domain;

import com.ls.order.enums.OrderStatusEnums;
import com.ls.order.enums.PayStatusEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @program: sell->OrderMaster
 * @description: 订单主表
 * @author: liushuai
 * @create: 2019-10-27 21:25
 **/

@Entity
@Data
@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderMaster {

    @Id
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


}
