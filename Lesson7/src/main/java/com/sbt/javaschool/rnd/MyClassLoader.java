package com.sbt.javaschool.rnd;

import java.io.*;
import java.lang.reflect.Method;
import java.util.List;

public class MyClassLoader extends ClassLoader {
    private final List<String> pathClass;
    private ModifyMain modifyMain;
    private String className;
    private String methodName;

    MyClassLoader(List<String> _pathClass, String _className, String _methodName) {
        modifyMain = new ModifyMain();
        pathClass = _pathClass;
        className = _className;
        methodName = _methodName;
    }

    public boolean findMethodInClass(Class<?> _class, String _name) throws NoSuchMethodException {
       Method method = _class.getMethod(_name);
       if(method.getName().equals(null))
       { return false;}
       return true;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (pathClass.isEmpty())
            return null;
        for (String s : pathClass) {
            File file = new File(s + "\\" + name + ".class");
            if (file.isFile()) {
                try {
                    byte[] byteFile = readFile(file);
                    Class temp = defineClass(className, byteFile, 0, byteFile.length);
                    if(findMethodInClass(temp, methodName))
                    return temp;
                } catch (FileNotFoundException | NoSuchMethodException e) {

                }
            }
        }
        throw new ClassNotFoundException("По указанноному пути класс " + name + " не найден");
        //return super.findClass(name);
    }

    private byte[] readFile(File f) throws FileNotFoundException {
        byte[] res = new byte[(int) f.length()];
        FileInputStream stream = new FileInputStream(f);
        try {
            stream.read(res, 0, res.length);
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return res;
        }

    }
}
