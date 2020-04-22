package com.nana.studyjavarepo.thread.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池的配置类，给容器中添加组件
 *
 * @author xingnana
 * @create 2019-12-19
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({ThreadPoolProperties.class})
@EnableAsync
public class ThreadPoolAutoConfiguration {

    private static final int THREADS = Runtime.getRuntime().availableProcessors() + 1;

    @Autowired
    private ThreadPoolProperties threadPoolProperties;

    /**
     * 异步任务执行器
     * @return
     */
    @Bean
    public Executor asyncServiceExecutor() {
        log.info("start asyncServiceExecutor");
        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(THREADS);
        //配置最大线程数
        executor.setMaxPoolSize(threadPoolProperties.getMaxPoolSize());
        //配置队列大小
        executor.setQueueCapacity(99999);
        //配置线程池中的线程的名称前缀
//        executor.setThreadNamePrefix("AsyncService-");
        executor.setThreadNamePrefix(threadPoolProperties.getThreadNamePrefix());

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }

}
