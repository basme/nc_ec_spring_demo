package com.netcracker.ec.spring.demo.core.bean.candidates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MotherBean {

    @Autowired
    private InterfaceOne oneImplSecond;

    @Autowired
    private Collection<InterfaceOne> ones;

    @Autowired
    private InterfaceTwo<String> stringTwo;

}
