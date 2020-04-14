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
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Test
    public void findByProductIdList(){
        List<String> productIdList = Stream.of("157875196366160022", "157875227953464068").collect(Collectors.toList());
        List<ProductInfo> productInfoList = productInfoRepository.findByProductIdIn(productIdList);
        log.info("【查询商品】：{}",JSON.toJSONString(productInfoList,SerializerFeature.PrettyFormat));
        Assert.assertTrue(productIdList.size()!=0);
    }
}