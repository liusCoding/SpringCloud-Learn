package com.ls.product.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @program: sell->ProductCategory
 * @description: 商品类目实体
 * @author: liushuai
 * @create: 2019-08-03 22:27
 **/

@Entity
@Data
//动态更新时间
@DynamicUpdate
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /** 类目名字 */
    private String categoryName;

    /** 类目编码 */
    private Integer categoryType;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 更新时间*/
    private LocalDateTime updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
