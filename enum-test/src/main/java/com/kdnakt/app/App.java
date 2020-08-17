package com.kdnakt.app;

/**
 * Hello world!
 *
 */
public class App {
    private static enum Fruit {
        APPLE, ORANGE, GRAPE;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(Fruit.valueOf("APPLE"));
        // Exception in thread "main" java.lang.IllegalArgumentException: No enum constant com.kdnakt.app.App.Fruit.apple
        System.out.println(Fruit.valueOf("apple"));
    }
}
