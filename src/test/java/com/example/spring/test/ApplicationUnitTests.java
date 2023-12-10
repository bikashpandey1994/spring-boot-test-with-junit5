package com.example.spring.test;

import com.example.spring.test.controllers.HomeController;
import com.example.spring.test.services.HomeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

// This annotation will only provide spring support to the test class.
// Configuration and initialization of beans needs to be done explicitly
// We can also mock beans using @MockBean instead of creating actual bean
@ExtendWith(SpringExtension.class)
public class ApplicationUnitTests {

    // Test configuration will be used for creating beans
    @TestConfiguration
    static class TestConfigurationClass {

        @Bean
        public HomeController homeController() {
            return new HomeController();
        }

        @Bean
        public HomeService homeService() {
            return new HomeService();
        }
    }

    @Autowired
    HomeController homeController;

    @Test
    public void homeControllerTest_OK() {

        assertTrue("Welcome to Home".equals(homeController.home()), "Test is Successful");
    }
}
