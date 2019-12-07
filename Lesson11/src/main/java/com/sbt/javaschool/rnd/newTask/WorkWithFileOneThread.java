package com.sbt.javaschool.rnd.newTask;

import java.io.*;
import java.util.*;

public class WorkWithFileOneThread implements WorkWithFile {

    private List<String> listFilePath = new ArrayList<String>();
    private String fileName;
    private ThreadBuffer thBuff = new ThreadBuffer();


    @Override
    public boolean addFilePath(String path) {
        listFilePath.add(path);
        return false;
    }

    @Override
    public boolean readData(ThreadBuffer thBuff) {
        Object mutex = new Object();


        for (String s : listFilePath) {

            Runnable runner = ()->{
                System.out.println("Поток чтения" +
                        "  " +
                        Thread.currentThread().getName());
                fileName = s;
                File f = new File(s);
                FileReader fr = null;
                try {
                    fr = new FileReader(f);
                    BufferedReader bfr = new BufferedReader(fr);
                    String str = bfr.readLine();
                    while (str != null) {
                        thBuff.add(str);
                        str = bfr.readLine();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            Thread thread = new Thread(runner);
            thread.start();
            thread.interrupt();
        }
        return false;
    }

    public String getFileName() {
        return fileName;
    }



}
