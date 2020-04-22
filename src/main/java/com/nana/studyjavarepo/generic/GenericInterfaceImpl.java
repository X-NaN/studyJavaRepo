package com.nana.studyjavarepo.generic;

/**
 * 泛型接口的实现类
 *
 * @author xingnana
 * @create 2020-04-22
 */
public class GenericInterfaceImpl<T> implements GenericInterface<T> {

    private T info;

    @Override
    public T getInfo() {
        return this.info;
    }

    @Override
    public void addInfo(T info) {
        this.info=info;
    }

    public static void main(String[] args) {
        GenericInterfaceImpl<String> stringGenericInterfaceImpl=new GenericInterfaceImpl<>();

        stringGenericInterfaceImpl.addInfo("hello");

        String s=stringGenericInterfaceImpl.getInfo();
        System.out.println(s);
    }
}
