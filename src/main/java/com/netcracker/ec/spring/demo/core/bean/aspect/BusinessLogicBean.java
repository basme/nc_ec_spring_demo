package com.netcracker.ec.spring.demo.core.bean.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusinessLogicBean {

    public void foo(String bar) {
        log.info("Some business logic with " + bar);
    }

    @Profiled("dev")
    public void devLogic() {
        log.info("Some dev logic");
    }

    @Profiled("prod")
    public void prodLogic() {
        log.info("Some prod logic");
    }

}
