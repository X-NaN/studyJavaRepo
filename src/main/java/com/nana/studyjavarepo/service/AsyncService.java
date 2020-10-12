package com.nana.studyjavarepo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
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

    /**
     * 异步执行
     * 有返回值
     *
     * @throws InterruptedException
     */
    @Async("asyncServiceExecutor")
    public Future<Object> executeTask(long taskId) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("异步执行任务Id: " + taskId);
        Future<Object> result = new AsyncResult(run(taskId));

        return result;
    }

    private String run(long taskId) {
        return "execute success";
    }

    @Async("asyncServiceExecutor")
    public void handleResut(List<Future<Object>> futureList) {

        for (Future<Object> future : futureList) {
            String result = null;
            try {
                result = (String) future.get();
                System.out.println("异步执行结果：" + result);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
