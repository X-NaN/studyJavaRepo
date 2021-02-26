package com.nana.studyjavarepo.thread.sync;

/**
 * 功能描述 <br>
 *
 * @author xingnana
 * @create 2/26/21
 */
public class ReentrantLockAccountTask implements Runnable {

    private ReentrantLockAccount account;

    public ReentrantLockAccountTask(ReentrantLockAccount account) {
        this.account = account;
    }


    @Override
    public void run() {
        account.deposit(100);
        account.withdraw(100);
        System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());

    }
}
