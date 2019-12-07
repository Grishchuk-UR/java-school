package com.sbt.javaschool.rnd.newTask;

import java.util.ArrayList;
import java.util.List;

public class ThreadBuffer {
    private List<String> list = new ArrayList<String>();

    public boolean add(String line) {
        if (line != null) {
            list.add(line);
            return true;
        }
        else return false;
    }
    public String get(){
        if(!list.isEmpty()){
            return list.remove(0);
        }
        return null;
    }
}
