package com.sbt.javaschool.rnd.terminal;

import com.sbt.javaschool.rnd.server.PinValidator;
import com.sbt.javaschool.rnd.server.TerminalServer;

public class Terminal implements ITerminal{

    private PinValidator pinValidator;
    private TerminalServer terminalServer;
    private int pin;


    @Override
    public boolean loginUser(String id, Integer pin) {
        pinValidator =null;
        pinValidator = new PinValidator();
        return false;
    }

    @Override
    public Integer getBalance(String id) {
        return null;
    }

    @Override
    public Integer putMoney(String id, Integer value) {
        return null;
    }

    @Override
    public Integer getMoney(String id, Integer value) {
        return null;
    }

    @Override
    public boolean unLoginUser() {
        return false;
    }
}
