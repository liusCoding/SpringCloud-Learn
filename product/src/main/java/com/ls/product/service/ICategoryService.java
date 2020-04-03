package com.ls.product.service;

import com.ls.product.domain.ProductCategory;

import java.util.List;

public interface ICategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);
}
