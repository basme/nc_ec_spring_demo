package com.netcracker.ec.spring.demo.core.bean.circular;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
@RequiredArgsConstructor
public class CircularA {

    private final CircularB b;

}
