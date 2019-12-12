package com.sbt.javaschool.rnd.threadPool;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool implements ThreadPool {
    private Integer threadCount;

    public void setRunning(boolean running) {
        isRunning = running;
    }

    private volatile boolean isRunning;

    BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    FixedThreadPool(Integer threadCount) {
        this.threadCount = threadCount;
    }

    public void start() {
        for (int i = 0; i < threadCount; i++) {
            new Thread(new Task()).start();
        }
        isRunning = true;
    }

    @Override
    public void execute(Runnable runnable) {
        queue.add(runnable);
    }



    private final class Task implements Runnable {

        @Override
        public void run() {
            while (isRunning) {
                Runnable nextTask = queue.poll();
                if (nextTask != null) {
                    nextTask.run();
                }
            }
        }
    }
}