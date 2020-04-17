package com.nana.studyjavarepo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * 异步任务
 *
 * @author xingnana
 * @create 2020-04-17
 */
@Service("asyncService")
public class AsyncService {

    @Async("asyncServiceExecutor")
    public void doTaskA() throws InterruptedException {
        System.out.println("MsgServer send A thread name->" + Thread.currentThread().getName());
        StopWatch stopWatch=new StopWatch("taskA");
        stopWatch.start();
        TimeUnit.SECONDS.sleep(2);

        stopWatch.stop();
        System.out.println("MsgServer send A 耗时：" + stopWatch.prettyPrint());
    }

    @Async("asyncServiceExecutor")
    public void doTaskB() throws InterruptedException {
        System.out.println("MsgServer send B thread name->" + Thread.currentThread().getName());
        StopWatch stopWatch=new StopWatch("taskA");
        stopWatch.start();
        TimeUnit.SECONDS.sleep(2);
        stopWatch.stop();
        System.out.println("MsgServer send B耗时：" + stopWatch.prettyPrint());
    }

}
