package com.nana.studyjavarepo.thread.async;

/**
 * 线程池配置类
 *
 * @author xingnana
 * @create 2020-04-17
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Data
@ConfigurationProperties(prefix = "task.pool")
public class ThreadPoolProperties {
    private int corePoolSize;

    private int maxPoolSize;

    private int keepAliveSeconds;

    private int queueCapacity;

    private String threadName;


}
