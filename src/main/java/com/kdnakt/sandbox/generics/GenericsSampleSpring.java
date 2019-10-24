package com.kdnakt.sandbox.generics;

public class GenericsSampleSpring extends SpringContainer<Person> {

    public static void main(String[] args) {
        SpringContainer<Person> c = new GenericsSampleSpring();
        c.print();// class com.kdnakt.sandbox.generics.Person
    }

}
