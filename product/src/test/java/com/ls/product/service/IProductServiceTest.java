package com.ls.product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ls.product.DTO.CartDTO;
import com.ls.product.ProductApplicationTests;
import com.ls.product.domain.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    @Test
    public void findByProductIdList(){
        List<String> productIdList = Stream.of("157875196366160022", "157875227953464068").collect(Collectors.toList());
        List<ProductInfo> productInfoList = productService.findByProductIdIn(productIdList);
        log.info("【查询商品】：{}", JSON.toJSONString(productInfoList, SerializerFeature.PrettyFormat));
        Assert.assertTrue(productIdList.size()!=0);
    }

    @Test
    public void decreaseStock(){

        CartDTO cartDTO = new CartDTO();
        cartDTO.setProductId(String.valueOf(157875196366160022L));
        cartDTO.setProductQuantity(9);
        productService.decreaseStock(Arrays.asList(cartDTO));
    }


}