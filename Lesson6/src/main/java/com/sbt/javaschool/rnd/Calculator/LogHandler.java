package com.sbt.javaschool.rnd.Calculator;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogHandler implements InvocationHandler {

    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    private final Object delegate;

    public LogHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = map.get((Integer) args[0]);
        if (result == null) {
            Integer size = map.put((Integer) args[0], (Integer) method.invoke(delegate, args));
            System.out.println("return calculate value: ");
            return method.invoke(delegate, args);
        } else {
            System.out.println("return proxy value: ");
            return result;
        }

    }
}
