package com.nana.studyjavarepo.service.taskRunner;

/**
 * 任务执行器
 *
 * @author xingnana
 * @create 2/27/21
 */
public interface TaskExecutor<T> {
    <T> void execute(T runInfo);
}
