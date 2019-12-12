package com.sbt.javaschool.rnd.threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public interface ThreadPool extends Executor {
    void start();

    void execute(Runnable runnable);

}
