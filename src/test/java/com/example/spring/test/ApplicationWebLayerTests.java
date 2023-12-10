package com.example.spring.test;

import com.example.spring.test.services.HomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// This annotation provides spring support to the test class and also
// initializes all web layer beans i.e. controller, interceptors etc.
// We have to create mock beans for other beans using @MockBean
@WebMvcTest
public class ApplicationWebLayerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HomeService service;

    @Test
    void homeController_OK() throws Exception {

        when(service.getWelcomeMessage()).thenReturn("Welcome to Home");
        this.mockMvc.perform(get("/home")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome to Home")));
    }
}
