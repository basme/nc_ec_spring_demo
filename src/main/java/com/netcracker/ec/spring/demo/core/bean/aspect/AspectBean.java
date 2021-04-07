package com.netcracker.ec.spring.demo.core.bean.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class AspectBean {

    @Value("${ec.spring.demo.profile:dev}")
    private String profile;

    @Pointcut("@annotation(Profiled)")
    public void atProfiled() {};

    @Before("execution(public * com.netcracker.ec.spring.demo.core.bean.aspect.BusinessLogicBean.foo(..))")
    public void beforeCallAtMethod1(JoinPoint jp) {
        final Object argument = jp.getArgs()[0];
        final String methodName = jp.getSignature().getName();
        log.info("Called method {} with arg {} at {}", methodName, argument, LocalDateTime.now());
    }

    @Around("atProfiled()")
    public Object interceptProfiled(ProceedingJoinPoint jp) {
        Method method = ((MethodSignature) jp.getSignature()).getMethod();
        final Profiled profileConfig = method.getAnnotation(Profiled.class);
        if (profile.equals(profileConfig.value())) {
            try {
                return jp.proceed();
            } catch (Throwable t) {
                // Some handling
                t.printStackTrace();
                return null;
            }
        } else {
            log.info("Call for method {} was suppressed, as it requires profile {} while now it is {}",
                    jp.getSignature().getName(), profileConfig.value(), profile);
            return null;
        }
    }

}
