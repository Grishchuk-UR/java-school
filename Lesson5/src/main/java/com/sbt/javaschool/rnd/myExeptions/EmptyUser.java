package com.sbt.javaschool.rnd.myExeptions;

public class EmptyUser extends Exception {
    public EmptyUser(String str)
    {
        System.out.println("Пользователя "+ str+ " не найден в системе \n добавьте пользователя или повторите ввод логина");
    }
}
