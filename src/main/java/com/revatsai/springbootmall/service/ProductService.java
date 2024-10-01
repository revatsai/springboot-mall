package com.revatsai.springbootmall.service;

import com.revatsai.springbootmall.dto.ProductRequest;
import com.revatsai.springbootmall.model.Product;

public interface ProductService {
    // 根據productId取得商品數據
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
