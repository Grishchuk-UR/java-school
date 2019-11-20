package com.sbt.javaschool.rnd.terminal;

public interface ITerminal {

    public boolean loginUser(String id, Integer pin);
    public Integer getBalance(String id);
    public Integer putMoney(String id, Integer value);
    public Integer getMoney(String id, Integer value);
    public boolean unLoginUser();
}
