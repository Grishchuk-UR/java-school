package com.sbt.javaschool.rnd.myExeptions;

public class IncorrectPin extends Exception {
    public IncorrectPin(String str){
        System.out.println(str);
    }
}
