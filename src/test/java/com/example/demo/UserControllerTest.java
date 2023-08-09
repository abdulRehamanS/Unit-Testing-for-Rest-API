package com.example.demo;


import com.example.demo.Controller.userController;
import com.example.demo.Service.userService;
import jdk.jfr.ContentType;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.print.attribute.standard.Media;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(value = userController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    private userService service;

    @Test
    public void testGetMsg() throws Exception {

        when(service.getuserName()).thenReturn("Hello, world!");

        // preparing the request
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome");
        //sending the request
        ResultActions perform = mockMvc.perform(requestBuilder);
        MvcResult result = perform.andReturn();
        MockHttpServletResponse response = result.getResponse();
        int status = response.getStatus();
        assertEquals(200, status);
    }

    // for post mapping unit testing rest api

//    @Test
//    public void testPostMapping() throws Exception
//    {
//        when(service.getuserName()).thenReturn("Post mapping request is working as per request");
//
//        // creating request
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("welcome")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(book);
//
//        // sending request
//        ResultActions perform = mockMvc.perform(requestBuilder);
//        MvcResult result = perform.andReturn();
//        MockHttpServletResponse response = result.getResponse();
//       int status= response.getStatus();
//       assertEquals(201,status);   //for https.CREATE code will be 201;
//
//    }

}

