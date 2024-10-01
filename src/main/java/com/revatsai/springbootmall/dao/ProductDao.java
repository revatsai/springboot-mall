package com.revatsai.springbootmall.dao;

import com.revatsai.springbootmall.dto.ProductRequest;
import com.revatsai.springbootmall.model.Product;

public interface ProductDao {
    // 根據productId取得商品數據
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
