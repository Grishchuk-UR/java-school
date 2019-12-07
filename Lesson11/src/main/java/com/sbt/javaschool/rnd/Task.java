package com.sbt.javaschool.rnd;

public class Task implements Runnable {

        public void run () {
            for (int i = 0; i < 3; i++) {
                System.out.print(String.format("#%d(%s)", i,
                        Thread.currentThread().getName()));
            }
        }
}
