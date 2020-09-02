package com.nana.studyjavarepo.thread;

/**
 * 线程操作
 *
 * @author xingnana
 * @create 2020-09-02
 */
public class ThreadOPSample {
    public static void main(String[] args) {
        ThreadExtend threadExtend=new ThreadExtend("继承Thread的线程");
        threadExtend.start();


        ThreadImplRunnable threadImplRunnable=new ThreadImplRunnable("实现Runnable接口的线程");
        Thread thread=new Thread(threadImplRunnable);
        thread.start();
    }
}
