package com.nana.studyjavarepo.thread;

import static java.lang.Thread.sleep;

public class ThreadImplRunnable implements Runnable {
    private String name;

    public ThreadImplRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "在执行");
            try {
                sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
