package com.netcracker.ec.spring.demo.ex.lake.simple;

import com.netcracker.ec.spring.demo.ex.lake.ducks.Duck;
import com.netcracker.ec.spring.demo.ex.lake.ducks.impl.BathDuck;
import com.netcracker.ec.spring.demo.ex.lake.ducks.impl.CyberpunkDuck;
import com.netcracker.ec.spring.demo.ex.lake.ducks.impl.SimpleDuck;
import com.netcracker.ec.spring.demo.ex.lake.ducks.impl.YoutubeDuck;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class Lake {

    private List<Duck> ducks;

    public Lake() {
        ducks = new ArrayList<>();
        ducks.add(new SimpleDuck());
        ducks.add(new BathDuck());
        ducks.add(new YoutubeDuck());
        ducks.add(new CyberpunkDuck());
        Collections.shuffle(ducks);
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
