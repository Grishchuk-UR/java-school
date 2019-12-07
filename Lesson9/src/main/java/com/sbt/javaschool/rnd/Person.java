package com.sbt.javaschool.rnd;

import java.util.Objects;

public class Person {


    private final boolean man;
    private final String name;
    private final Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return man == person.man &&
                Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(man, name, age);
    }

    public Person(boolean man, String name, Integer age) {
        this.man = man;
        this.name = name;
        this.age = age;

    }

    public boolean isMan() {
        return man;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }







}
