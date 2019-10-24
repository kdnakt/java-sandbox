package com.kdnakt.sandbox.generics;

public class GenericsSampleWithClass extends Container<Person> {

    public GenericsSampleWithClass() {
        super(Person.class);
    }

    public static void main(String[] args) {
        Container<Person> c = new GenericsSampleWithClass();
        c.print();// class com.kdnakt.sandbox.generics.Person
    }

}
