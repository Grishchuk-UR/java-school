package com.sbt.javaschool.rnd;

public class Person
{
    public static final boolean RESEDENT = true;
    public static final boolean NOT_RESIDENT =false;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }



    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private boolean isResident;


    public Person()
    {}
    public Person(String firstName, String lastName)
    {

        this.firstName = firstName;
        this.lastName = lastName;

    }
}
