package com.menuorder.demo.service;

import com.menuorder.demo.entity.*;
import com.menuorder.demo.repository.*;
import com.menuorder.demo.util.Security;
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

    @Autowired
    CustomerRepository customerRepository;

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

    public Customer createCustomer(Customer customer){ return customerRepository.save(customer);}

    public Administrator createAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    public Customer findByUserName(String userName){
        return customerRepository.findByUserName(userName);
    }

    public Customer findCustomerByUsernameAndPassword(String userName, String password) {return customerRepository.findCustomerByUsernameAndPassword(userName, Security.md5(password));}

    public Administrator findAdminByUsernameAndPassword(String userName, String password)
    {
        return administratorRepository.findAdminByUsernameAndPassword(userName, password);
    }

    public List<Food> getAll(){
        return foodRepository.getAll();
    }
}
