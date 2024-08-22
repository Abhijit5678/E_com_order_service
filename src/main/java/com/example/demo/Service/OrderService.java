package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entiy.Order;

public interface OrderService {

	Order saveOrder(Order order);

	List<Order> getOrderListByProductId(int productId);

	
}
