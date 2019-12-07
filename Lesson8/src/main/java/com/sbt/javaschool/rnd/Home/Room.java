package com.sbt.javaschool.rnd.Home;

public class Room {

    private Double weight;
    private Double length;
    private Double height;

    public Room(Double height, Double weight, Double length) {
        this.height = height;
        this.weight = weight;
        this.length = length;
    }


    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }



}
