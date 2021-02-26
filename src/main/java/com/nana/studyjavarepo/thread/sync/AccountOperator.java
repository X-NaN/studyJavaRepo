package com.nana.studyjavarepo.thread.sync;

/**
 * 账户操作类
 * 有明确对象作为对象锁
 *
 * @author xingnana
 * @create 2020-09-10
 */
public class AccountOperator implements Runnable {
    private Account account;

    public AccountOperator(Account account) {
        this.account = account;
    }

    @Override
    public void run() {

        /** 用synchronized 给account对象加了锁。这时，当一个线程访问account对象时，
         * 其他试图访问account对象的线程将会阻塞，直到该线程访问account对象结束。
         * 也就是说谁拿到那个锁谁就可以运行它所控制的那段代码。 */
        // 存钱
        account.deposit(500);
        // 取钱
        account.withdraw(500);
        System.out.println(Thread.currentThread().getName() + "," + account.name + ":" + account.getBalance());
    }
}
