package com.menuorder.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.menuorder.demo.entity.*;
import com.menuorder.demo.service.MenuOrderService;
import com.menuorder.demo.service.SampleService;
import com.menuorder.demo.util.Security;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MenuOrderServiceTest {

    @Spy
    MenuOrderService menuOrderService;
    private MockMvc mvc;
    private JacksonTester<SampleEntity> jsonSuperHero;
    @Autowired
    ApplicationContext actx;


    @Before
    public void setup() {
        // We would need this line if we would not use MockitoJUnitRunner
        // MockitoAnnotations.initMocks(this);
        // Initializes the JacksonTester
        JacksonTester.initFields(this, new ObjectMapper());
        // MockMvc standalone approach
        menuOrderService = (MenuOrderService) actx.getBean("menuOrderService");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void canFindCustomerByUsernameAndPassword() {
       Customer customer = menuOrderService.findCustomerByUsernameAndPassword("linax", "81DC9BDB52D04DC20036DBD8313ED055");
        assertThat(customer.getEmail()).isEqualTo("linaf");
    }

    @Test
    public void canCreateProduct() throws Exception {
        // Food food = new Food("ice cream", 150, 5.80);
        Food chocolate = new Food("chocolate", 200, 7.80);
        Food chips = new Food("chips", 200, 9.2);
        menuOrderService.createFood(chocolate);
        menuOrderService.createFood(chips);
    }

    @Test
    public void canCreateOrder() throws Exception {
        //Food food = new Food("chicken", 250, 15.80);
        // List<Food> lists = new ArrayList<>();
        // lists.add(food);
        List<Food> lists = menuOrderService.getAll();
        Order order = new Order(new Date(), 5, new Date(), lists);

        List<Chef> chefs = menuOrderService.getAllChefs();

        order.setChefs(chefs);


        menuOrderService.createOrder(order);

    }

    @Test
    public void canCreateCustomer() throws Exception {
        Customer customer = new Customer("lina123", "fung", "linaf", "04562378", "123 we st", "try", "mitcham", "vic", "australia", "3132", "linax", Security.md5("1234"));
        menuOrderService.createCustomer(customer);
    }

    @Test
    public void canFindByUserName() throws Exception {
        Customer customer = menuOrderService.findByUserName("linax");
        assertThat(customer.getEmail()).isEqualTo("test");
    }

    @Test
    public void canCreateAdministrator() throws Exception {

        Administrator administrator = new Administrator("lina123", "fung", "linaf", "04562378", "xxxxxx", "123 we st", "try", "mitcham", "vic", "australia", "3132");
        menuOrderService.createAdministrator(administrator);
    }

    @Test
    public void canCreateChef() throws Exception {
        //Food food = new Food("chicken", 250, 15.80);
        // List<Food> lists = new ArrayList<>();
        // lists.add(food);
        Chef chef = new Chef("bob23", "vc67", "bobv34", "04562378", "xxxxxx", "123 we st", "try", "mitcham", "vic", "australia", "3132", -1l);

        menuOrderService.createChef(chef);

    }

}
