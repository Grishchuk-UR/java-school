package com.sbt.javaschool.rnd.myExeptions;

public class IncorrectCash extends Exception {
    public IncorrectCash(){
        System.out.println("Сумма не кратна 100, повторите попытку снова");
    }
}
