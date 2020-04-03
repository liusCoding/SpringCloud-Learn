package com.ls.product.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @program: sell->ProductInfo
 * @description: 商品实体
 * @author: liushuai
 * @create: 2019-08-04 07:35
 **/

@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    /** 商品ID */
    @Id
    private String productId;

    /** 商品名字 */
    private String productName;

    /** 商品单价 */
    private BigDecimal productPrice;

    /** 商品库存 */
    private Integer productStock;

    /** 商品描述 */
    private String productDescription;

    /** 商品小图 */
    private String productIcon;

    /** 商品的状态  0正常  1下架*/
    private Integer productStatus = 0;

    /** 类目编号*/
    private Integer categoryType;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

//    @JsonIgnore
//    public ProductStatusEnum getProductStatusEnum(){
//        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
//    }


}
