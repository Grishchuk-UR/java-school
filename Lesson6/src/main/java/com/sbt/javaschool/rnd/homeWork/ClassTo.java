package com.sbt.javaschool.rnd.homeWork;

import java.util.List;

public class ClassTo {
    public static Integer _number;
    public static String _string;
    public static Double _double;
    private static Float _float;
    public static List _list;

    public static Integer get_number() {
        return _number;
    }

    public static String get_string() {
        return _string;
    }

    public static void set_list(List _list) {
        ClassTo._list = _list;
    }

    public static void set_number(Integer _number) {
        ClassTo._number = _number;
    }

    public static void set_string(String _string) {
        ClassTo._string = _string;
    }

    public static void set_double(Double _double) {
        ClassTo._double = _double;
    }

    private static void set_float(Float _float) {
        ClassTo._float = _float;
    }


}
