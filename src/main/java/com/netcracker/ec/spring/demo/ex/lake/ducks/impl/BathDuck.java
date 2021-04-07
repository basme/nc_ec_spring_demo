package com.netcracker.ec.spring.demo.ex.lake.ducks.impl;

import com.netcracker.ec.spring.demo.ex.lake.ducks.Duck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
public class BathDuck implements Duck {

    @Override
    public void sound() {
        log.info("*Makes no sound*");
    }
}
