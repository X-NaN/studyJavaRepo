package com.nana.studyjavarepo.thread.sync;

/**
 * 同步线程
 * synchronized可以修饰方法，修饰代码块
 * 当修饰普通方法和代码块时，锁的是某个对象
 * 当修饰静态方法时，锁的是这个类的所有对象，所有对象共用一把锁
 *
 * @author xingnana
 * @create 2020-09-10
 */
public class SyncThread implements Runnable {
    private int count;

    public SyncThread() {
        count = 0;
    }

    @Override
    public void run() {
        /** this对象锁,在执行synchronized代码块时会锁定当前的对象*/
        synchronized (this) {
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

    }

    /** 没有明确对象作为锁时，可以创建一个特殊的对象来作为锁*/
    private byte[] lock = new byte[0];  // 特殊的instance变量
    public void method()
    {
        synchronized(lock) {
            // todo 同步代码块
        }
    }


}
