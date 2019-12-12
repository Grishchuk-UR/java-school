package com.sbt.javaschool.rnd.threadPool;

public class Task implements Runnable {

        public void run () {
            Integer res  = 1;
            for (int i = 500; i < 1000; i++) {

                    res = res*i;
                    res = res/2;


            }
            System.out.print(String.format("#%d(%s)", res,
                    Thread.currentThread().getName()));
        }
}
