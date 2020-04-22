package com.nana.studyjavarepo.generic;

/**
 * 泛型-类型通配符
 *
 * (1)?(类型实参)： List<?> list
 * (2)上限通配符: List<? extends Number> Number的子类
 * (3)下限通配符: List <? super Integer>
 * @author xingnana
 * @create 2020-04-22
 */
public class GenericWildcard<T> {
    private T info;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
        System.out.println("设置info:" + info);
    }


}
