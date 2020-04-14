package com.ls.product.service;

import com.ls.product.DTO.CartDTO;
import com.ls.product.domain.ProductInfo;

import java.util.List;

public interface IProductService {

    /**
     * 查询所有上架的商品
     * @author liushuai
     * @param
     * @return
     */
    List<ProductInfo> findAll();


    /**
     * 根据商品id集合查询啥品
     * @author liushuai
     * @param productIdList
     * @return
     */
    List<ProductInfo> findByProductIdIn(List<String> productIdList);

    /**
     * 扣库存
     * @author liushuai
     * @param cartDTOList
     * @return
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
