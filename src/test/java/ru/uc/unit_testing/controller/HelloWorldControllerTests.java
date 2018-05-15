package ru.uc.unit_testing.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.uc.unit_testing.HelloWorldController;
import ru.uc.unit_testing.business.ItemBusinessService;
import ru.uc.unit_testing.model.Item;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public void helloWorld() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello-world")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello world"))
                .andReturn();

    }

    @Test
    public void dummyItem() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10}"))
                .andReturn();
    }

    @Test
    public void itemFromBusinessLayer () throws Exception {

        when(businessService.retrieveHardcodedItem()).thenReturn(new Item(1, "Ball", 10, 100));

        RequestBuilder request = MockMvcRequestBuilders
                                    .get("/item-from-business-layer")
                                    .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(content().json("{id:1, name: Ball, price: 10}"))
                .andReturn();
    }

    @Test
    public void getAllItems () throws Exception {

        when(businessService.retrieveAllItems())
            .thenReturn(
                Arrays.asList(
                    new Item(1, "Ball", 10, 100),
                    new Item(2, "Ball 2", 10, 100)
                ));


        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(content().json("[{id:1, name: Ball, price: 10},{id:2, name: \"Ball 2\", price: 10}]"))
                .andReturn();
    }
}
