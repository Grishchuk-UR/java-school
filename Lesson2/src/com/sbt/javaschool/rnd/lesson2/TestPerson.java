package com.sbt.javaschool.rnd.lesson2;

public class TestPerson {
    public static void main(String[] args) {
        InterfacePerson person = new Person(true, "Sam", true);
        InterfacePerson person1 = new Person(false, "Lile", false);
        if (person.Marry((Person) person1)) {
            System.out.println("Yes");
        }

        person1.Marry(new Person(true, "Don", false));
        //person.spouse = new Person(false, "Lile", true);


    }
}
