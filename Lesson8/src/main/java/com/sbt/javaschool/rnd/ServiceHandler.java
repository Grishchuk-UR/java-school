package com.sbt.javaschool.rnd;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ServiceHandler implements InvocationHandler {

    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    private static Object obj;

    public ServiceHandler(Object _obj) {
        this.obj = _obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
