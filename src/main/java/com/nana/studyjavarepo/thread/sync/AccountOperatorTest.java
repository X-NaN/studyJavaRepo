package com.nana.studyjavarepo.thread.sync;

/**
 * 多线程 测试对象锁
 *
 * @author xingnana
 * @create 2020-09-10
 */
public class AccountOperatorTest {
    public static void main(String[] args) {
        Account account = new Account("nana", 10000f);
        AccountOperator accountOperator = new AccountOperator(account);
        final int THREAD_NUM = 3;
        Thread[] threads = new Thread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i++) {
            // 多线程操作账户
            threads[i] = new Thread(accountOperator);
            threads[i].start();
        }
    }
}