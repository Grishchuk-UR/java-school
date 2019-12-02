package com.sbt.javaschool.rnd.homeWork;

import org.jetbrains.annotations.Contract;
import org.w3c.dom.ls.LSOutput;

import javax.imageio.stream.ImageInputStream;

public class ClassFrom {
    public static Integer _number;
    public static String _string;
    public static Double _double;
    private static Float _float;

    public static Integer get_number() {
        return _number;
    }
    public static void say() {
        System.out.println("Say: Say");
    }

    public static String get_string() {
        return _string;
    }

    public static Double get_double() {
        return _double;
    }
    private static Float get_float() {

        return _float;
    }
}
