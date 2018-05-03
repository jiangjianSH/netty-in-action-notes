package com.jiangjian.learning.netty.chap7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        executorService.schedule(new Runnable() {
            public void run() {
                System.out.println("hi, I am jiangjian");
            }
        }, 60, TimeUnit.SECONDS);
        executorService.shutdown();
    }


}
