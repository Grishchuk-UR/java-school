package com.sbt.javaschool.rnd;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ServiceHandler implements InvocationHandler {

    private static Map<Object, Object> map = new HashMap<Object, Object>();
    private static Object obj;
    String path;

    public ServiceHandler(Object _obj, String _path) {
        this.obj = _obj;
        this.path = _path;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.isAnnotationPresent(ICache.class)){
            ICache iCache = method.getAnnotation(ICache.class);
            if(iCache.cacheType().equals(CacheType.MEMORY)){
                Object object = map.get(args[0]);
                if(object==null){
                    map.put(args[0], method.invoke(obj, args[0]));
                }
            }else if(iCache.cacheType().equals(CacheType.FILE)){

            }
        }
        return null;
    }
}
