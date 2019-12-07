package com.sbt.javaschool.rnd.Calculator;

import java.lang.reflect.Proxy;

public class  CalculatorMain {
    public static void main(String[] args) {
        ICalculator calculator = new Calculator();
        calculator.calc(6);
        calculator.calc(3);
        Calculator aa = new Calculator();

        //InvocationHandler ih = new LogHandler(calculator);

        ICalculator proxyCalc = (ICalculator) Proxy.newProxyInstance(Calculator.class.getClassLoader(),
                Calculator.class.getInterfaces(),
                new LogHandler(calculator));

        System.out.println(proxyCalc.calc(1));
        System.out.println(proxyCalc.calc(11));
        System.out.println(proxyCalc.calc(4));
        System.out.println(proxyCalc.calc(6));
        System.out.println(proxyCalc.calc(4));
        System.out.println(proxyCalc.calc(1));
        System.out.println(proxyCalc.calc(11));

    }

}
