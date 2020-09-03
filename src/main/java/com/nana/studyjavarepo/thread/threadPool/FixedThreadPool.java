package com.nana.studyjavarepo.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定长度线程池，可控制线程并发数，超出的线程会在队列中等待
 * 定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()
 * @author xingnana
 * @create 2020-09-03
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        // 由于线程池大小为3，则每两秒打印3个数字
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


    }

}
