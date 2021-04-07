package com.netcracker.ec.spring.demo.core.bean.inception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InceptionPuzzler {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void foo() {
        // Some logic here
        for (int i = 0; i < 10; i++) {
            bar();
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void bar() {
        // Some other logic here
    }

    /*
        -- 0
        -- 1
        -- 2
        -- 3
        -- 10
        -- 11
        -- 12
        -- 13
     */

}
