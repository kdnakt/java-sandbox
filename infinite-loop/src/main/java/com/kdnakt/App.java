package com.kdnakt;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ExecutorService es = Executors.newFixedThreadPool(2);
        int taskId = 1;
        es.submit(new MyTask(taskId++));
        es.submit(new MyTask(taskId++));
    }

    public static class MyTask implements Runnable {
        int id;

        MyTask(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {}
                System.out.println("Task " + id + " ... " + new Date());
            }
        }
    }
}
