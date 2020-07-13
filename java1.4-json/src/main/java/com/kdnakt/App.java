package com.kdnakt;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class App {

    public static class Person {
        public String name;
        public int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public Person() {}

        public void setName(String name) {
            this.name = name;
        }
        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        String json = "{\"name\":\"jake\", \"age\":30}";
        Person jake = (Person) JSONObject.toBean(JSONObject.fromObject(json), Person.class);
        System.out.println(jake.name);
        System.out.println();
        json = "[[{\"name\":\"joe\", \"age\":31},{\"name\":\"jack\", \"age\":32}],null,[{\"name\":\"jane\", \"age\":33}]]";
        JSONArray arr = JSONArray.fromObject(json);
        System.out.println(arr.toString());
        System.out.println(arr.size());
        System.out.println(arr.get(0).getClass().getName());
        System.out.println(arr.get(1));
        System.out.println(arr.get(2));
        System.out.println();

        JSONArray pArr = (JSONArray) arr.get(0);
        System.out.println(pArr);
        System.out.println();

        Person joe = (Person) JSONObject.toBean(JSONObject.fromObject(pArr.get(0)), Person.class);
        System.out.println(joe.name);
    }
}
