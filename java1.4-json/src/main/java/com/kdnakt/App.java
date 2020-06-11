package com.kdnakt;

import net.sf.json.JSONObject;

public class App {

    public static class Person {
        public final String name;
        public final int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Person jake = new Person("jake", 30);
        System.out.println(JSONObject.fromObject(jake));
    }
}
