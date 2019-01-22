package com.menuorder.demo.controller;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.menuorder.demo.entity.Administrator;
import com.menuorder.demo.entity.Chef;
import com.menuorder.demo.entity.Customer;
import com.menuorder.demo.entity.Food;
import com.menuorder.demo.service.MenuOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MenuOrderController {
    @Autowired
    MenuOrderService menuOrderService;

    @RequestMapping(value = "/findByUserName")
    public Customer findByUserName(String userName) {
        return menuOrderService.findByUserName(userName);
    }


    @RequestMapping(value = "/findByUserNameAndPassword")
    public Customer findCustomerByUsernameAndPassword(String userName, String password) {
        return menuOrderService.findCustomerByUsernameAndPassword(userName, password);
    }


    @RequestMapping(value = "/findAdminByUserNameAndPassword")
    public Administrator findAdminByUsernameAndPassword(String userName, String password) {
        return menuOrderService.findAdminByUsernameAndPassword(userName, password);
    }

    @RequestMapping(value = "/createAdmin",  method = RequestMethod.POST)
    public Administrator createAdministrator(@RequestBody Administrator administrator) {
        return menuOrderService.createAdministrator(administrator);
    }

    @RequestMapping(value = "/createFood",  method = RequestMethod.POST)
    public Food createFood(@RequestBody Food food) {
        return menuOrderService.createFood(food);
    }

    @RequestMapping(value = "/createCustomer",  method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer) {
        return menuOrderService.createCustomer(customer);
    }

    @RequestMapping(value = "/createChef",  method = RequestMethod.POST)
    public Chef createChef(@RequestBody Chef chef) {
        return menuOrderService.createChef(chef);
    }
}
