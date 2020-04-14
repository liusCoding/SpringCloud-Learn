package com.ls.product.service.impl;

import com.ls.product.DTO.CartDTO;
import com.ls.product.domain.ProductInfo;
import com.ls.product.enums.ResultEnum;
import com.ls.product.exception.ProductException;
import com.ls.product.repository.ProductInfoRepository;
import com.ls.product.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static com.ls.product.enums.ProductStatusEnuum.UP;

/**
 * @program: product->ProductServiceImpl
 * @description:
 * @author: liushuai
 * @create: 2020-04-03 14:27
 **/
@Service
public class ProductServiceImpl implements IProductService {
    private final ProductInfoRepository productInfoRepository;

    public ProductServiceImpl(ProductInfoRepository productInfoRepository) {
        this.productInfoRepository = productInfoRepository;
    }

    /**
     * 查询所有上架的商品
     *
     * @return
     * @author liushuai
     */
    @Override
    public List<ProductInfo> findAll() {
        return productInfoRepository.findByProductStatus(UP.getCode());
    }

    /**
     * 根据商品id集合查询啥品
     *
     * @param productIdList
     * @return
     * @author liushuai
     */
    @Override
    public List<ProductInfo> findByProductIdIn(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    /**
     * 扣库存
     *
     * @param cartDTOList
     * @return
     * @author liushuai
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = productInfoRepository.findById(cartDTO.getProductId()).orElse(null);
            //判断商品是否存在
            if(Objects.isNull(productInfo)){
                throw  new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //库存是否足够
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result<0){
                throw  new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
