package com.revatsai.springbootmall.service;

import com.revatsai.springbootmall.dto.ProductQueryParams;
import com.revatsai.springbootmall.dto.ProductRequest;
import com.revatsai.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    Integer countProduct(ProductQueryParams productQueryParams);

//    List<Product> getProducts(ProductCategory category, String search);
    List<Product> getProducts(ProductQueryParams productQueryParams);
    // 根據productId取得商品數據
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
