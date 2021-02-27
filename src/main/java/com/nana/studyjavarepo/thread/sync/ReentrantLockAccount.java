package com.nana.studyjavarepo.thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述 <br>
 *
 * @author xingnana
 * @create 2/26/21
 */
public class ReentrantLockAccount extends Account {

    private Lock lock = new ReentrantLock();

    public ReentrantLockAccount(String name, float amonut) {
        this.name = name;
        this.amonut = amonut;
    }

    /**
     * 存钱
     *
     * @param amt
     */
    @Override
    public void deposit(float amt) {
        lock.lock();
        try {
            amonut += amt;
        } finally {
            lock.unlock();
        }

    }

    /**
     * 取钱
     *
     * @param amt
     */
    @Override
    public void withdraw(float amt) {

        lock.lock();
        try {
            amonut -= amt;
        } finally {
            lock.unlock();
        }
    }

}
