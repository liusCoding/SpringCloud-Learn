package com.ls.product.service;

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
}
