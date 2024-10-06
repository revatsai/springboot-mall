package com.revatsai.springbootmall.service;

import com.revatsai.springbootmall.model.Order;
import com.revatsai.springbootmall.dto.CreateOrderRequest;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
