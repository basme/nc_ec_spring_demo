package com.netcracker.ec.spring.demo.core;

import com.netcracker.ec.spring.demo.core.bean.aspect.BusinessLogicBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
public class CoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CoreApplication.class);
        new CoreApplication().testAop(context);
    }

    private void testAop(ApplicationContext context) {
        final BusinessLogicBean bean = context.getBean(BusinessLogicBean.class);
        bean.foo("Payload");
        bean.devLogic();
        bean.prodLogic();
    }

}
