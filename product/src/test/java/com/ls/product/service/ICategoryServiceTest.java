package com.ls.product.service;

import com.ls.product.ProductApplicationTests;
import com.ls.product.domain.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class ICategoryServiceTest extends ProductApplicationTests {

    @Autowired
    private ICategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(Arrays.asList(11, 22));
        Assert.assertTrue(categoryList.size()>0);
    }
}