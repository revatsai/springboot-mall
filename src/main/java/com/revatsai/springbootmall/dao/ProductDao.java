package com.revatsai.springbootmall.dao;

import com.revatsai.springbootmall.dto.ProductQueryParams;
import com.revatsai.springbootmall.dto.ProductRequest;
import com.revatsai.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);
    // 根據productId取得商品數據
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void updateStock(Integer productId, Integer stock);

    void deleteProductById(Integer productId);
}
