package com.menuorder.demo.service;

import com.menuorder.demo.entity.Administrator;
import com.menuorder.demo.entity.Chef;
import com.menuorder.demo.entity.Food;
import com.menuorder.demo.entity.Order;
import com.menuorder.demo.repository.AdministratorRepository;
import com.menuorder.demo.repository.ChefRepository;
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

    @Autowired
    ChefRepository chefRepository;

    @Autowired
    AdministratorRepository administratorRepository;

    public Food createFood(Food food) {
        return foodRepository.save(food);
    }



    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Chef> getAllChefs(){
        return chefRepository.getAll();
    }

    public Chef createChef(Chef chef) {
        return chefRepository.save(chef);
    }

    public Administrator createAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    public List<Food> getAll(){
        return foodRepository.getAll();
    }
}
