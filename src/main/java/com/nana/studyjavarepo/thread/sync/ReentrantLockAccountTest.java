package com.nana.studyjavarepo.thread.sync;

/**
 * 功能描述 <br>
 *
 * @author xingnana
 * @create 2/26/21
 */
public class ReentrantLockAccountTest {
    public static void main(String[] args) {
        ReentrantLockAccount account=new ReentrantLockAccount("nana",100);
        ReentrantLockAccountTask accountTask=new ReentrantLockAccountTask(account);
        final int THREAD_NUM = 3;
        Thread[] threads=new Thread[THREAD_NUM];
        for(int i=0;i<THREAD_NUM;i++){
            threads[i]=new Thread(accountTask);
            threads[i].start();
        }
    }
}
