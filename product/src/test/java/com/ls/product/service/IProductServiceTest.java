package com.ls.product.service;

import com.ls.product.ProductApplicationTests;
import com.ls.product.domain.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class IProductServiceTest extends ProductApplicationTests {

    @Autowired
    private IProductService productService;
    @Test
    public void findAll() {
        List<ProductInfo> productInfos = productService.findAll();
        log.info("productInfos:{}",productInfos);
        Assert.assertTrue(productInfos.size()>0);
    }
}