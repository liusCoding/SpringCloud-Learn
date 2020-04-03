package com.ls.product.repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ls.product.ProductApplicationTests;
import com.ls.product.domain.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class ProductCategoryRepositoryTest extends ProductApplicationTests {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findByOrCategoryTypeIn() {
        List<ProductCategory> categories = productCategoryRepository.findByOrCategoryTypeIn(Arrays.asList(11, 22));
        log.info("cates:{}", JSON.toJSONString(categories, SerializerFeature.PrettyFormat));
        Assert.assertTrue(categories.size()>0);
    }
}