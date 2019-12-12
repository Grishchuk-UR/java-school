package com.sbt.javaschool.rnd.threadPool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.concurrent.BlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;



public class ScalableThreadPool implements ThreadPool {

    private volatile boolean isRunning = false;
    BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    private List<Thread> threadList = new ArrayList<>();
    private AtomicInteger counterFreeThreads = new AtomicInteger(0);
    private Integer threadMin;
    private Integer threadMax;

    public ScalableThreadPool(Integer threadMin, Integer threadMax) {
        if (threadMax < threadMin) {
            this.threadMin = threadMax;
            this.threadMax = threadMin;
        } else {
            this.threadMax = threadMax;
            this.threadMin = threadMin;
        }
        if (this.threadMin.equals(0))
            this.threadMin = 1;
    }

    public boolean getRunFlag() {
        return true;
    }

    public void start() {
        for (int i = 0; i < threadMin; i++) {
            threadList.add(new Thread(new Task()));
            threadList.get(i).start();
            threadList.get(i).interrupt();
            counterFreeThreads.incrementAndGet();
        }
        isRunning = true;
    }

    public void disable() {
        isRunning = false;
    }

    @Override
    public void execute(Runnable runnable) {
        if (counterFreeThreads.get() > 0) {
            removeFreeThreads();
        } else {
            if(threadList.size() < threadMax){
                threadList.add(new Thread(new Task()));
                threadList.get(threadList.size()-1).start();
                threadList.get(threadList.size()-1).interrupt();
                System.out.println("add new thread");
            }
        }
        queue.offer(runnable);
    }

    private void removeFreeThreads() {
        if (threadList.size() > threadMin) {
            Iterator<Thread> iterator = threadList.iterator();
            if (iterator.hasNext()) {
                if (iterator.next().getState().equals(Thread.State.WAITING)) {
                    System.out.println("remove thread");
                    iterator.remove();
                    System.out.println("count thread"+ threadList.size());

                }
            }
        }
    }


    private final class Task implements Runnable {
        private boolean runFlag = false;

        public boolean isRunFlag() {
            return runFlag;
        }

        @Override
        public void run() {
            while (isRunning) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Runnable newTask = queue.poll();
                if (newTask != null) {
                    runFlag = true;

                    newTask.run();
                    counterFreeThreads.decrementAndGet();

                    System.out.println("Thread Id" +  Thread.currentThread().getName().toString());

                } else {
                    if (runFlag) {
                        counterFreeThreads.incrementAndGet();
                        runFlag = false;
                        try {
                            this.wait(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Thread Id" +  Thread.currentThread().getName().toString());

                    }
                }
            }
        }
    }
}
