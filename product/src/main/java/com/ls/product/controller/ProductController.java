package com.ls.product.controller;

import com.google.common.collect.Lists;
import com.ls.product.domain.ProductCategory;
import com.ls.product.domain.ProductInfo;
import com.ls.product.service.ICategoryService;
import com.ls.product.service.IProductService;
import com.ls.product.utils.ResultVoUtil;
import com.ls.product.vo.ProductInfoVo;
import com.ls.product.vo.ProductVo;
import com.ls.product.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @program: product->ProductController
 * @description:
 * @author: liushuai
 * @create: 2020-04-03 11:04
 **/

@RestController
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService;
    private final ICategoryService categoryService;

    public ProductController(IProductService productService, ICategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    /**
     * 1.查询所有在架的商品
     * 2.获取类目的type列表
     * 3.查询类目
     * 4.构造数据
     */

    @RequestMapping("/list")
    public ResultVo<List<ProductVo>> list(){
        //1.查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findAll();

        //2.获取类目的type列表
        List<Integer> categoryTypes = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(toList());

        //3.获取类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypes);

        List<ProductVo> productVos = Lists.newArrayList();
        categoryList.forEach(category ->{
            ProductVo productVo = new ProductVo();
            BeanUtils.copyProperties(category,productVo);

            //获取属于该类目下的所有商品
            List<ProductInfo> productInfos = productInfoList.stream()
                    .filter(productInfo -> productInfo.getCategoryType().equals(category.getCategoryType()))
                    .collect(toList());

            List<ProductInfoVo> productInfoVoList = productInfos.stream()
                    .map(productInfo -> {
                        ProductInfoVo productInfoVo = new ProductInfoVo();
                        BeanUtils.copyProperties(productInfo, productInfoVo);
                        return productInfoVo;
                    }).collect(toList());
            productVo.setProductInfoVoList(productInfoVoList);
            productVos.add(productVo);
        });


        return ResultVoUtil.success(productVos);
    }
}

