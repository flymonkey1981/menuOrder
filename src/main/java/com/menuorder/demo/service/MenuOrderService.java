package com.menuorder.demo.service;

import com.menuorder.demo.entity.Food;
import com.menuorder.demo.entity.Order;
import com.menuorder.demo.repository.FoodRepository;
import com.menuorder.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuOrderService {
    @Autowired
    FoodRepository foodRepository;

    @Autowired
    OrderRepository orderRepository;

    public Food createFood(Food food) {
        return foodRepository.save(food);
    }



    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Food> getAll(){
        return foodRepository.getAll();
    }
}
