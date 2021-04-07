package com.netcracker.ec.spring.demo.core.bean.inception;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InceptionRunner {

    private final InceptionPuzzler puzzler;

    @Transactional(propagation = Propagation.REQUIRED)
    public void baz() {
        puzzler.foo();
    }

}
