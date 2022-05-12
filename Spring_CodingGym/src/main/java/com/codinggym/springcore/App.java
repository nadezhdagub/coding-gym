package com.codinggym.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class);
        ControlCenter controlCenter = ctx.getBean("controlCenter", ControlCenter.class);
        controlCenter.takeFlights();
    }
}