package com.sbt.javaschool.rnd;

import com.sbt.javaschool.rnd.threadPool.ScalableThreadPool;
import com.sbt.javaschool.rnd.threadPool.Task;
import com.sbt.javaschool.rnd.threadPool.ThreadPool;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class ScalableThreadPoolTest {

    @Test
    void execute() throws InterruptedException {
        ThreadPool thPool = new ScalableThreadPool(4, 6);
        thPool.start();
        for(int i = 0; i<100; i++) {

            TimeUnit.MILLISECONDS.sleep(100);
            thPool.execute(new Task());
        }
    }
}