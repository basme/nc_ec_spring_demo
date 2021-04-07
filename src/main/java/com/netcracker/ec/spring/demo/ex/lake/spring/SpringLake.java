package com.netcracker.ec.spring.demo.ex.lake.spring;

import com.netcracker.ec.spring.demo.ex.lake.ducks.Duck;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class SpringLake {

    private final Collection<Duck> ducks;

    public SpringLake(Collection<Duck> ducks) {
        this.ducks = ducks;
    }

    public void be() {
        final Random delays = new Random();
        final ExecutorService lakeMaster = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ducks.forEach(d -> lakeMaster.execute(() -> IntStream.range(0, 10).forEach(i -> {
            try {
                d.sound();
                Thread.sleep(delays.nextInt(3) * 1000);
            } catch (InterruptedException e) {
                log.error("Someone is interrupting our ducks right NOW!");
            }
        })));
        lakeMaster.shutdown();
    }

}
