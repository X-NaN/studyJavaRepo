package com.nana.studyjavarepo.generic;

/**
 * 泛型-类型通配符
 * <p>
 * (1)?(类型实参)： List<?> list
 * (2)上限通配符: List<? extends Number> Number的子类
 * (3)下限通配符: List <? super Integer>
 *
 * @author xingnana
 * @create 2020-04-22
 */
public class GenericWildcard<T extends Number> {
    private T info;

    public GenericWildcard(T info){
        this.info=info;
    }

    public T getInfo() {
        System.out.println("设置info:" + info);
        return info;
    }


    public static void main(String[] args) {
        GenericWildcard<Integer> stringGenericWildcard=new GenericWildcard(1111);

        GenericWildcard<Float> floatGenericWildcard=new GenericWildcard<>(22.22f);
        GenericWildcard<Double> doubleGenericWildcard=new GenericWildcard<>(2.5677);

        stringGenericWildcard.getInfo();
        floatGenericWildcard.getInfo();
        doubleGenericWildcard.getInfo();

    }


}
