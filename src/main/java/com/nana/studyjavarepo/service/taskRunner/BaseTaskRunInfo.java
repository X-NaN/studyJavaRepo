package com.nana.studyjavarepo.service.taskRunner;

import java.util.List;

/**
 * 功能描述 <br>
 *
 * @author xingnana
 * @create 2/27/21
 */
public class BaseTaskRunInfo<T, L> {
    T taskInfo;
    L taskLog;
    List<BaseCaseRunInfo> caseRunInfos;
    private String executeBy;

}
