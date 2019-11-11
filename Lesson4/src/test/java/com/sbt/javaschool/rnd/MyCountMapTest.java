package com.sbt.javaschool.rnd;

import org.junit.Assert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

class MyCountMapTest {

    CountMap<Integer> testMap;

    @BeforeEach
    void makeTestData(){
         testMap = new MyCountMap<>();
        testMap.add(11);
        testMap.add(9);
        testMap.add(1);
        testMap.add(3);
        testMap.add(1);
        testMap.add(22);
        testMap.add(77);
        testMap.add(31);
        testMap.add(6);
        testMap.add(41);
        testMap.add(41);
        testMap.add(5);
        testMap.add(31);
        testMap.add(1);
        testMap.add(11);
    }


    @Test
    void add() {
        testMap.add(99);
        Assert.assertEquals(testMap.size(), 11);
    }


    @Test
    void getCount() {
        Assert.assertEquals(testMap.getCount(1), 3);
    }

    @Test
    void remove() {
        testMap.remove(1);
        int index = testMap.size();
        Assert.assertEquals(index, 9);
    }

    @Test
    void size() {
        Assert.assertEquals(testMap.size(), 10);
    }

    @Test
    void addAll() {
        CountMap<Integer> newMap = new MyCountMap<>();
        newMap.add(11);
        newMap.add(9);
        newMap.add(1);
        newMap.add(3);
        newMap.add(123);

        testMap.addAll(newMap);
        System.out.printf("Test add new key");
        Assert.assertEquals(testMap.size(), 11);
        System.out.printf("Test sum value");
        Assert.assertEquals(testMap.getCount(1), 4);
    }

    @Test
    void toMap() {
        Map map = testMap.toMap();
        Assert.assertEquals(testMap.size(), map.size());
    }

    @Test
    void destinationToMap() {
        Map map = new TreeMap();
        testMap.toMap(map);
        Assert.assertEquals(testMap.size(), map.size());

    }
}