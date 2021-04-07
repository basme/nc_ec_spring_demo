package com.netcracker.ec.spring.demo.core.bean;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LombokInjections {

    private final LifecycleBean lifecycleBean;
    private final DependentBean dependentBean;


}
