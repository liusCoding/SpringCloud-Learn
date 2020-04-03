package com.ls.product.service.impl;

import com.ls.product.domain.ProductCategory;
import com.ls.product.repository.ProductCategoryRepository;
import com.ls.product.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: product->CategoryServiceImpl
 * @description:
 * @author: liushuai
 * @create: 2020-04-03 14:37
 **/
@Service
public class CategoryServiceImpl implements ICategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    public CategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes) {

        return productCategoryRepository.findByOrCategoryTypeIn(categoryTypes);
    }
}
