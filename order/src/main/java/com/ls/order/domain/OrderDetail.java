package com.ls.order.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @program: sell->OrderDetail
 * @description: 订单详情
 * @author: liushuai
 * @create: 2019-10-27 21:56
 **/

@Entity
@Data
@DynamicUpdate
@Builder
public class OrderDetail {

    /** 订单详情 */
    @Id
    private String orderDetailId;

    /** 订单id */
    private String orderId;

    /** 商品id */
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 商品单价 */
    private BigDecimal productPrice;

    /** 商品数量 */
    private Integer productQuantity;

    /** 商品图标 */
    private String productIcon;

    @Tolerate
    public OrderDetail() {
    }
}
