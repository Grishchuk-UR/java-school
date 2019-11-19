package com.sbt.javaschool.rnd.Calculator;

public class Calculator implements ICalculator {

    @Override
    public Integer calc(Integer value) {
        if (value < 0)
            return 0;
        if (value == 0)
            return 1;
        return value * calc(value - 1);
    }
}
