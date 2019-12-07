package com.sbt.javaschool.rnd.Home;

public class ClassRoom extends Room{
    private Integer table;
    private int cheer;


    public ClassRoom(Double height, Double weight, Double length) {
        super(height, weight, length);
    }

    public Integer getTable() {
        return table;
    }

    public void setTable(Integer table) {
        this.table = table;
    }

    public int getCheer() {
        return cheer;
    }

    public void setCheer(int cheer) {
        this.cheer = cheer;
    }
}
