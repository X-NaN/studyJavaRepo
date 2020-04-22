package com.nana.studyjavarepo.generic;

/**
 * 泛型接口
 *
 * @author xingnana
 * @create 2020-04-22
 */
public interface GenericInterface<T> {

    T getInfo();

    void addInfo(T info);
}
