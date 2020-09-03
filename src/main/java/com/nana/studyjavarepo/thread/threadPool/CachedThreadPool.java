package com.nana.studyjavarepo.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 可缓存线程池，如果线程池超长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
 *
 * @author xingnana
 * @create 2020-09-03
 */
public class CachedThreadPool {
    public static void main(String[] args) {
//        ThreadPoolExecutor
        ExecutorService cachedThreadPool= Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            final int index=i;
            try {
                Thread.sleep(index*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }
}
