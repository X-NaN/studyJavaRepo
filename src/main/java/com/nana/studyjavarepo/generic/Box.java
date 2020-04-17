package com.nana.studyjavarepo.generic;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/12/14  17:12
 * Description: 泛型类
 * 泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。
 * 泛型类创建的对象getClass()为同一个Class
 * <p>
 * Modified By:
 */
public class Box<T> {
    private T data;

    public Box() {

    }

    public Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
