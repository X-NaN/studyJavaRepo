package com.nana.studyjavarepo.sample;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Import动态导入一批Bean
 *
 * @author xingnana
 * @create 2020-06-28
 */
public class MyImportSelector implements ImportSelector {


    /**
     * 用于返回全类名数组。所以利用该特性可以给容器动态导入 N 个 Bean。
     * @param annotationMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.nana.studyjavarepo.sample.Student"};
    }
}
