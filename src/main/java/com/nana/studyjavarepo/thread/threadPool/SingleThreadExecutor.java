package com.nana.studyjavarepo.thread.threadPool;

import com.nana.studyjavarepo.thread.ThreadImplRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单线程线程池，它只会用唯一的工作线程来执行任务，以保证所有任务按照指定顺序（FIFO,LIFO，优先级）执行
 *
 * @author xingnana
 * @create 2020-09-03
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor= Executors.newSingleThreadExecutor();
        ThreadImplRunnable threadImplRunnable=new ThreadImplRunnable("单线程线程池");
        for(int i=0;i<10;i++){
            singleThreadExecutor.execute(threadImplRunnable);
        }

    }
}
