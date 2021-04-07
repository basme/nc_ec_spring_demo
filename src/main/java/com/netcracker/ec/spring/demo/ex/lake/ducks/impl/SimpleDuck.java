package com.netcracker.ec.spring.demo.ex.lake.ducks.impl;

import com.netcracker.ec.spring.demo.ex.lake.ducks.Duck;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleDuck implements Duck {

    public void sound() {
        log.info("Quack");
    }

}
