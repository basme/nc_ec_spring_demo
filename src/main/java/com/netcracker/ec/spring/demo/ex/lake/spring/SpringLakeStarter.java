package com.netcracker.ec.spring.demo.ex.lake.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringLakeStarter {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringLakeConfig.class);
        final SpringLake lake = context.getBean(SpringLake.class);
        lake.be();
    }

}
