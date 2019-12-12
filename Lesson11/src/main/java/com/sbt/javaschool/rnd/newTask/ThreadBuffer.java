package com.sbt.javaschool.rnd.newTask;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class ThreadBuffer {
    private List<String> list = new ArrayList<String>();
    Object lock = new Object();

    public boolean add(String line) {
        synchronized (lock) {
            if (line != null) {
                list.add(line);
                return true;
            } else return false;
        }
    }
    public String get() {
        synchronized (lock) {
            if (!list.isEmpty()) {
                return list.remove(0);
            }
            return null;
        }

    }
}
