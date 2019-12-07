package com.sbt.javaschool.rnd.newTask;

import java.util.*;

public class Worker {
    private Map<String, Integer> mapWordInFile = new HashMap<>();
    private Set<String> set = new HashSet<>();

    public boolean worker(ThreadBuffer thBuff, String name){

            String str = thBuff.get();
            String[] arrStr;
            if (str != null) {
                arrStr = parseLine(str);
            } else return false;
            Integer i = mapWordInFile.get(name);
            if (i == null)
                mapWordInFile.put(name, countWord(arrStr));
            else mapWordInFile.put(name, i + countWord(arrStr));

//        System.out.println("В файле " + name + " " + mapWordInFile.get(name) + " слов" +
//                "  " +
//                Thread.currentThread().getName());
            return true;
    }

    private String[] parseLine(String line) {
        if (line != null) {
            return line.split(" ");
        }
        return null;
    }

    private Integer countWord(String[] arr) {
        if (arr != null)
            set.addAll(Arrays.asList(arr));
        return set.size();
    }
}
