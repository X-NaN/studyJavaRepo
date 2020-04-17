package com.nana.studyjavarepo.thread;

public class ThreadExtend extends Thread {
    private String name;//thread name

    public ThreadExtend(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程" + name + "在执行" + i);

            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
