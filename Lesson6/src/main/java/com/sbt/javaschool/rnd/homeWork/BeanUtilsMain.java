package com.sbt.javaschool.rnd.homeWork;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsMain {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        BeanUtils.assign(new ClassTo(), new ClassFrom());
    }


}
