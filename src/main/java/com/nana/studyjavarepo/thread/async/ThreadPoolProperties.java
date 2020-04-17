package com.nana.studyjavarepo.thread.async;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 线程池配置类
 * ThreadPoolProperties中的属性名必须要与配置文件中的application.yml中的一致
 * @author xingnana
 * @create 2020-04-17
 */
@Data
@ConfigurationProperties(prefix = "task.pool")
public class ThreadPoolProperties {
    private int corePoolSize;

    private int maxPoolSize;

    private int keepAliveSeconds;

    private int queueCapacity;

    private String threadNamePrefix;


}
