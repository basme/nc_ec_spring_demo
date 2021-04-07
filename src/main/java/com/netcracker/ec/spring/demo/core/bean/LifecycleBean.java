package com.netcracker.ec.spring.demo.core.bean;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class LifecycleBean implements InitializingBean {

    @Autowired
    private DependentBean dependentBean;

    private OtherDependentBean otherDependentBean;

    @Autowired
    private void setDependency(OtherDependentBean otherDependentBean) {
        this.otherDependentBean = otherDependentBean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("We're in afterPropertiesSet");
    }

    @PostConstruct
    private void postConstruct() {
        log.info("We're in postConstruct");
    }

}
