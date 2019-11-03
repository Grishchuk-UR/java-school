package com.sbt.javaschool.rnd.lesson2;

public class Person {


    private final boolean man;
    private final String name;
    private final Integer age;

    private Person spouse;

    public Person(boolean man, String name, Integer age) {
        this.man = man;
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return this.age;
    }

    public boolean isMan() {
        return this.man;
    }

    public boolean Marry(Person person) {
        if (this.spouse == null) {
            if (person.man != this.man) {
                if (this.age > 18 && person.age > 18) {
                    if (person.spouse != null)
                        person.Divorce();
                    person.spouse = this;
                    this.spouse = person;
                    System.out.println(this.name + " and " + person.name + " happy married \n");
                    return true;
                } else {
                    System.out.println("Your very young for marriage");
                    return false;
                }
            } else {
                System.out.println("Oh! Only traditional marriage!");
                return false;

            }
        } else {
            if (this.Divorce())
                this.Marry(person);
        }
        return true;

    }

    public boolean Divorce() {
        if (this.spouse != null) {
            String name = this.spouse.name;
            this.spouse.spouse = null;
            this.spouse = null;
            System.out.println(this.name + " and " + name + " divorce");
            return true;
        } else
            return false;
    }


}
