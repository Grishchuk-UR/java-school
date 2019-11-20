package com.sbt.javaschool.rnd.homeWork;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanUtils {

    public static void assign(Object to, Object from) throws InvocationTargetException, IllegalAccessException {
        Class classFrom = from.getClass();
        Class classTo = to.getClass();

        for (Method mFrom : classFrom.getMethods()) {
            if (Modifier.isPublic(mFrom.getModifiers())) {
                String nameFrom = mFrom.getName();
                if(nameFrom.startsWith("get")) {
                    String strFrom = nameFrom.substring(("get").length());

                    for (Method mTo : classTo.getMethods()) {
                        if (Modifier.isPublic(mTo.getModifiers())) {
                            String nameTo = mTo.getName();
                            if (nameTo.startsWith("set")) {
                                String strTo = nameTo.substring(("set").length());
                                if(strFrom.equals(strTo)){
                                    if(mTo.getParameterTypes()[0].getName().equals(mFrom.getReturnType().getName())){
                                        mTo.invoke(to, mFrom.invoke(from));
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
    }

}
