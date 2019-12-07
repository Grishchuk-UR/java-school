package com.sbt.javaschool.rnd.newTask;

public class Main {
    public static void main(String[] args) {
        WorkWithFile work = new WorkWithFileOneThread();
        Worker worker = new Worker();
        ThreadBuffer thBuff = new ThreadBuffer();
        work.addFilePath("C:\\tmp\\file1.txt");
        work.addFilePath("C:\\tmp\\file2.txt");
        work.addFilePath("C:\\tmp\\file3.txt");
        work.addFilePath("C:\\tmp\\file4.txt");
        work.addFilePath("C:\\tmp\\file5.txt");
        Object lock = new Object();
        Runnable rn = () -> {
            synchronized (lock) {
                work.readData(thBuff);
            }
        };
        Runnable rnW = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (lock) {
                    worker.worker(thBuff, "");
                }
            }
        };
        Thread thRead = new Thread(rn);
        Thread thWorker = new Thread(rnW);
        thRead.start();
        thWorker.start();


    }
}
