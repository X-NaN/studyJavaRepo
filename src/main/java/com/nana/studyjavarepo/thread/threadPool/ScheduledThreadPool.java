package com.nana.studyjavarepo.thread.threadPool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定长线程池，支持定时及周期性任务执行
 *
 * @author xingnana
 * @create 2020-09-03
 */
public class ScheduledThreadPool {

    /**
     * 延迟执行
     */
    public static void delayExe(){
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(5);

        System.out.println(new Date());
        // 延迟3秒执行
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟3秒");
            }
        },3, TimeUnit.SECONDS);
    }

    /**
     *
     */
    public static void timerExe(){
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(5);

        // 延迟1秒后，每3秒执行一次
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟1秒后，每3秒执行一次");

            }
        },1,3,TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        ScheduledThreadPool.delayExe();
        ScheduledThreadPool.timerExe();

    }
}
