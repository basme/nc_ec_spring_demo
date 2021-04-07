package com.netcracker.ec.spring.demo.core.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class ServiceWithValues {

    @Value("${ec.spring.demo.testSetting}")
    private String setting;

    @Value("${some.migging.value:Default stub}")
    private String defaulted;

    @PostConstruct
    public void logSettings() {
        log.info(setting);
        log.info(defaulted);
    }

}
