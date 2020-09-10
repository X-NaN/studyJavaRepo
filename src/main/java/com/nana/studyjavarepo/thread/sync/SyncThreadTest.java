package com.nana.studyjavarepo.thread.sync;

/**
 * synchronized 方法测试
 * 一个线程访问一个对象的synchronized代码块时，别的线程可以访问该对象的非synchronized代码块而不受阻塞。
 *
 * @author xingnana
 * @create 2020-09-10
 */
public class SyncThreadTest {
    public static void main(String[] args) {
        SyncThread s1 = new SyncThread();
        SyncThread s2 = new SyncThread();

        /** 线程t1 t2访问不同的对象s1,s2中的sync方法，仍然是异步执行*/
        System.out.println("线程t1 t2访问不同的对象s1,s2中的sync方法，仍然是异步执行");
//        Thread t1 = new Thread(s1);
//        Thread t2 = new Thread(s2);
//        t1.start();
//        t2.start();

        /** 线程t3 t4访问同一个对象s3中的sync方法，会同步执行*/
//        System.out.println("线程t3 t4访问同一个对象s3中的sync方法，会同步执行");
        SyncThread s3 = new SyncThread();
        Thread t3 = new Thread(s3);
        Thread t4 = new Thread(s3);
        t3.start();
        t4.start();
    }
}
