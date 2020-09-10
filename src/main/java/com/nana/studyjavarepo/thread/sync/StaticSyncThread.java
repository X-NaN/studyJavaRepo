package com.nana.studyjavarepo.thread.sync;

/**
 * 当修饰静态方法时，锁的是这个类的所有对象，所有对象共用一把锁
 *
 * @author xingnana
 * @create 2020-09-10
 */
public class StaticSyncThread implements Runnable {

    private static int count;

    public StaticSyncThread() {
        count = 0;
    }

    public synchronized static void method() {
        for (int i = 0; i < 3; i++) {
            count++;
            System.out.println(Thread.currentThread().getName() + ":" + count);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        method();
    }
}
