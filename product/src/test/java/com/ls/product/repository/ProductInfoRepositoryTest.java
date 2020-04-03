package com.ls.product.repository;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ls.product.ProductApplicationTests;
import com.ls.product.domain.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class ProductInfoRepositoryTest extends ProductApplicationTests {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus(){
        List<ProductInfo> productInfos = productInfoRepository.findByProductStatus(0);
        log.info("productInfo:{}", JSON.toJSONString(productInfos, SerializerFeature.PrettyFormat));
        Assert.assertNotEquals(productInfos.size(),0);

    }
}