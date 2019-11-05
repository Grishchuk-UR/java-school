package com.sbt.javaschool.rnd.lesson2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person p1;
    private Person p2;
    private Person p3;
    private Person p4;

    @BeforeEach
    public void createPerson() {
        p1 = new Person(true, "Sam", 22);
        p2 = new Person(false, "Ann", 18);
        p3 = new Person(false, "Lille", 16);
        p4 = new Person(true, "Don", 42);
    }

    @Test
    void marry() {
        createPerson();
        boolean test1 = p1.Marry(p2); //женим
        Assert.assertTrue(test1);
        boolean test2 = p2.Marry(p1); //проверяем, что уже женаты
        Assert.assertFalse(test2);
        boolean test3 = p2.Marry(p3);//проверяем пол
        Assert.assertFalse(test3);
        boolean test4 = p3.Marry(p4); //проверяем возраст
        Assert.assertFalse(test4);
        boolean test5 = p4.Marry(p1); //проверяем пол еще раз
        Assert.assertFalse(test5);
    }

    @Test
    void divorce() {
        createPerson();
       if(p1.Marry(p2)) {
           boolean test1 = p1.Divorce();
           Assert.assertTrue(test1);
       }
        boolean test2 = p1.Divorce();
        Assert.assertFalse(test2);
    }
}