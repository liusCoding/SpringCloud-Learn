package com.ls.product.service.impl;

import com.ls.product.domain.ProductInfo;
import com.ls.product.repository.ProductInfoRepository;
import com.ls.product.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ls.product.enums.ProductStatusEnuum.UP;

/**
 * @program: product->ProductServiceImpl
 * @description:
 * @author: liushuai
 * @create: 2020-04-03 14:27
 **/
@Service
public class ProductServiceImpl implements IProductService {
    private final ProductInfoRepository productInfoRepository;

    public ProductServiceImpl(ProductInfoRepository productInfoRepository) {
        this.productInfoRepository = productInfoRepository;
    }

    /**
     * 查询所有上架的商品
     *
     * @return
     * @author liushuai
     */
    @Override
    public List<ProductInfo> findAll() {
        return productInfoRepository.findByProductStatus(UP.getCode());
    }
}
