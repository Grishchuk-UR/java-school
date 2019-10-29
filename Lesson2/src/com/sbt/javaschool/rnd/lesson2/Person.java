package com.sbt.javaschool.rnd.lesson2;

public class Person implements InterfacePerson {
    private final boolean man;
    private final String name;
    private boolean marry;

    private Person spouse;


    public Person(boolean man, String name, boolean marry) {
        this.man = man;
        this.name = name;
        this.marry = marry;
    }

    public boolean Marry(Person person) {
        if (this.spouse == null)
            if (person.man != this.man) {
                if (person.spouse != null)
                    person.Divorce();
                this.spouse = person;
                person.spouse = this.spouse;
                person.marry = true;
                this.marry = true;
                System.out.println(this.name + " and " + person.name + " happy married \n");
                return true;
            } else {
                System.out.println("Oh! Only traditional marriage!");
                return false;
            }
        else {
            this.Divorce();

            if (person.spouse != null)
                person.Divorce();
            return true;
        }
    }

    public boolean Divorce() {
        if (this.spouse != null) {
            this.spouse = null;
            System.out.println(this.name + " divorce");
            return true;
        } else
            return false;
    }


}
