package com.sbt.javaschool.rnd;

public interface ThreadPool {
    void start();

    void execute(Runnable runnable);

}
