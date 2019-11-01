package com.sbt.javaschool.rnd.lesson2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person(true, "Sam", 37);
        Person person1 = new Person(false, "Lilli", 15);
        person.Marry( person1);

        person1.Marry(new Person(true, "Don", 72));
        //person.spouse = new Person(false, "Lilli", true);

       // FileInputStream file1 = new FileInputStream("test.txt");
        //file1.
    }
}
