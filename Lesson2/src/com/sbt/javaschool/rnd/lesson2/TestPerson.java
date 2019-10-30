package com.sbt.javaschool.rnd.lesson2;

public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person(true, "Sam", 22);
        Person person1 = new Person(false, "Lile", 26);
        person.Marry( person1);


        person1.Marry(new Person(true, "Don", 33));
        //person.spouse = new Person(false, "Lile", true);


    }
}
