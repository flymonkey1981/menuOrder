package com.menuorder.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.menuorder.demo.entity.SampleEntity;
import com.menuorder.demo.service.MenuOrderService;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MenuOrderControllerTest {
    @InjectMocks
    private MenuOrderController menuOrderController;
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
        mvc = MockMvcBuilders.standaloneSetup(menuOrderController).build();
        menuOrderService = (MenuOrderService) actx.getBean("menuOrderService");
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void canFindyByUserName() throws Exception {
        // when
        mvc.perform(
                get("/findByUserName?userName=linax")).andDo(print()).andExpect(status().isOk()).andExpect(content().json("{email:\"linaf\",phoneNumber:\"04562378\"}"));

        // then

        //assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    public void canFindyByUserNameAndPassword() throws Exception {
        // when
        mvc.perform(
                get("/findByUserNameAndPassword?userName=linax&&password=1234")).andDo(print()).andExpect(status().isOk()).andExpect(content().json("{email:\"linaf\",phoneNumber:\"04562378\"}"));

        // then

        //assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

}
