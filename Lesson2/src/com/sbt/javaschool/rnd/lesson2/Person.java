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

    public String getName() {   return name;   }
    public Person getSpouse() {
        return this.spouse;
    }

    public Integer getAge() {
        return age;
    }

    public boolean isMan() {
        return this.man;
    }

    public boolean Marry(Person person) {
        if (this.spouse == null) {
            if (person.isMan() != this.isMan()) {
                if (this.getAge() >= 18 && person.getAge() >= 18) {
                    if (person.getSpouse() != null)
                        person.Divorce();
                    person.spouse = this;
                    this.spouse = person;
                    System.out.println(this.name + " and " + person.getName() + " happy married \n");
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
            if (this == person.getSpouse() && this.getSpouse() == person) {
                System.out.println(this.name + " and " + person.getName() + " already married \n");
                return false;
            }
            if (this.Divorce()) {
                this.Marry(person);
                return false;
            }
        }
        return true;

    }

    public boolean Divorce() {
        if (this.spouse != null) {
            String name = this.spouse.getName();
            this.spouse.spouse = null;
            this.spouse = null;
            System.out.println(this.name + " and " + name + " divorce");
            return true;
        } else
            return false;
    }


}
