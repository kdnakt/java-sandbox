package com.kdnakt.sandbox.generics;

public class GenericsSampleWithoutClass extends Container<Person> {

    public static void main(String[] args) {
        Container<Person> c = new GenericsSampleWithoutClass();
        c.print();// class com.kdnakt.sandbox.generics.Person
    }

}
