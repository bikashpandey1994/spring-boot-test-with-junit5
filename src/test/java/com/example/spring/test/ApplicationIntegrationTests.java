package com.example.spring.test;

import com.example.spring.test.controllers.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// @SpringBootTest annotation provides spring support to the test class and also
// Bootstraps whole application context, so we don't have to create any beans manually
// Unless we want to mock the bean.

// SpringBootTest.WebEnvironment.MOCK : indicates mock servlet container.
// In this set up, the full Spring application context is started but without the server.

// SpringBootTest.WebEnvironment.RANDOM_PORT : indicates web application runs in a random port.
// In this set up, the full Spring application context is started but on the server with a random port.

// SpringBootTestApplication.class : indicates configuration class.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringBootTestApplication.class)
// Enables Mock MVC
@AutoConfigureMockMvc
// This will override same properties present in application.properties of main application module
// If not specified it will default to application.properties present in test module
@TestPropertySource(
        locations = "classpath:application.properties")
class ApplicationIntegrationTests {

    @Value("${spring.prop.test}")
    private String propTest;

    //Random port on which tests are running
    @LocalServerPort
    private int port;

    @Autowired
    HomeController homeController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        System.out.println("Prop Test Value : " + propTest);
        assertThat(homeController).isNotNull();
        assertThat(mockMvc).isNotNull();
    }

    @Test
    void homeController_OK() throws Exception {

        this.mockMvc.perform(get("/home")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome to Home")));
    }

}
