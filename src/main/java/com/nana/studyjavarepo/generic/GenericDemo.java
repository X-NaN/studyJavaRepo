package com.nana.studyjavarepo.generic;

/**
 * 泛型类
 *
 * @author xingnana
 * @create 2020-04-22
 */
public class GenericDemo<T> {

    private T info;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
        System.out.println("设置info:" + info);
    }

    /**
     * 泛型方法
     *
     * @param clazz
     * @param <E>   <E> 声明该方法是泛型方法，尖括号内字母可以是任意的A,B,C...
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public <E> E getClassInstance(Class<E> clazz) throws IllegalAccessException, InstantiationException {
        E e = clazz.newInstance();
        return e;
    }

    /**
     * 静态方法无法访问类上定义的泛型；如果静态方法要使用泛型的话，必须将静态方法也定义成泛型方法 。
     *
     * @param genericDemo
     * @param <E>
     */
    public static <E> void printInfo(GenericDemo<E> genericDemo) {
        System.out.println("打印info:" + genericDemo.getInfo());
    }

    public static void main(String[] args) {
        // 泛型类
        GenericDemo<String> stringGenericDemo = new GenericDemo<>();
        GenericDemo<Integer> integerGenericDemo = new GenericDemo<>();
        GenericDemo<Boolean> booleanGenericDemo = new GenericDemo<>();

        stringGenericDemo.setInfo("abcdefff");
        integerGenericDemo.setInfo(123);
        booleanGenericDemo.setInfo(true);

        System.out.println("泛型类——泛型类获取特定类型对象-String:");
        String info = stringGenericDemo.getInfo();
        System.out.println(info);


        // 泛型方法
        try {
            GenericDemo genericDemo = new GenericDemo();
            Object object = genericDemo.getClassInstance(Class.forName("com.nana.studyjavarepo.generic.GenericDemo"));
            System.out.println("泛型方法——调用泛型方法，获取实例化对象instance:");
            System.out.println(object);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 静态方法的泛型
        System.out.println("泛型方法-静态方法:");
        GenericDemo.printInfo(stringGenericDemo);
    }
}
