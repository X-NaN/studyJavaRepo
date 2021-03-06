package com.nana.studyjavarepo.thread.sync;

/**
 * 账户类
 *
 * @author xingnana
 * @create 2020-09-10
 */
public class Account {
    String name;
    float amonut;

    public Account(){}

    public Account(String name, float amonut) {
        this.name = name;
        this.amonut = amonut;
    }

    /**
     * 存钱
     * synchronized保证并发存钱没问题
     *
     * @param amt
     */
    public synchronized void deposit(float amt) {
        amonut += amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 取钱
     * synchronized保证并发取钱没问题
     *
     * @param amt
     */
    public synchronized void withdraw(float amt) {
        amonut -= amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public float getBalance() {
        return amonut;
    }

}
