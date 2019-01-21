package com.menuorder.demo.controller;


import com.menuorder.demo.entity.Administrator;
import com.menuorder.demo.entity.Customer;
import com.menuorder.demo.service.MenuOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuOrderController {
    @Autowired
    MenuOrderService menuOrderService;

    @RequestMapping(value = "/findByUserName")
    public Customer findByUserName(String userName) {
        return menuOrderService.findByUserName(userName);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/findByUserNameAndPassword")
    public Customer findCustomerByUsernameAndPassword(String userName, String password) {
        return menuOrderService.findCustomerByUsernameAndPassword(userName, password);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/findAdminByUserNameAndPassword")
    public Administrator findAdminByUsernameAndPassword(String userName, String password) {
        return menuOrderService.findAdminByUsernameAndPassword(userName, password);
    }
}
