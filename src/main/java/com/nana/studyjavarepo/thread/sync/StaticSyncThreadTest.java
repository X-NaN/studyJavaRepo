package com.nana.studyjavarepo.thread.sync;

/**
 *
 *
 * @author xingnana
 * @create 2020-09-10
 */
public class StaticSyncThreadTest {
    public static void main(String[] args) {
        StaticSyncThread s1=new StaticSyncThread();
        StaticSyncThread s2=new StaticSyncThread();

        Thread t1=new Thread(s1);
        Thread t2=new Thread(s2);

        t1.start();
        t2.start();
    }
}
