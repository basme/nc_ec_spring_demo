package com.netcracker.ec.spring.demo.core.bean;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
@Slf4j
public class SingletonBean {

    private final PrototypeBean prototypeBean;
    private final ObjectFactory<PrototypeBean> prototypeFactory;

    @PostConstruct
    private void someLogic() {
        final PrototypeBean first = prototypeFactory.getObject();
        final PrototypeBean second = prototypeFactory.getObject();
        if (first == second) {
            log.error("Prototype does not work!");
        } else {
            log.info("Prototype works!");
        }
    }

}
