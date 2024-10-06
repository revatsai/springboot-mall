package com.revatsai.springbootmall.service;

import com.revatsai.springbootmall.dto.OrderQueryParams;
import com.revatsai.springbootmall.model.Order;
import com.revatsai.springbootmall.dto.CreateOrderRequest;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
