package com.revatsai.springbootmall.service.impl;

import com.revatsai.springbootmall.dao.ProductDao;
import com.revatsai.springbootmall.model.Product;
import com.revatsai.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
