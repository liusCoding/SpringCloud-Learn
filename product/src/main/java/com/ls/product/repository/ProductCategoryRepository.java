package com.ls.product.repository;

import com.ls.product.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findByOrCategoryTypeIn(List<Integer> categoryTypeList);
}
