package com.netcracker.ec.spring.demo.ex.lake.spring;

import com.netcracker.ec.spring.demo.ex.lake.ducks.Duck;
import com.netcracker.ec.spring.demo.ex.lake.ducks.impl.BathDuck;
import com.netcracker.ec.spring.demo.ex.lake.ducks.impl.CyberpunkDuck;
import com.netcracker.ec.spring.demo.ex.lake.ducks.impl.SimpleDuck;
import com.netcracker.ec.spring.demo.ex.lake.ducks.impl.YoutubeDuck;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@Configuration
public class SpringLakeConfig {

    @Bean
    public SpringLake springLake(Collection<Duck> ducks) {
        return new SpringLake(ducks);
    }

    @Bean
    public BathDuck bathDuck() {
        return new BathDuck();
    }

    @Bean
    public SimpleDuck simpleDuck() {
        return new SimpleDuck();
    }

    @Bean
    public YoutubeDuck youtubeDuck() {
        return new YoutubeDuck();
    }

    @Bean
    public CyberpunkDuck cyberpunkDuck() {
        return new CyberpunkDuck();
    }

}
