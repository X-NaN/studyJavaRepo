package com.nana.studyjavarepo.base;

/**
 * 类初始化顺序
 * 1.静态变量初始化
 * 2.静态初始化块
 * 3.成员变量，初始化块
 * 4.构造器
 *
 *
 * @author xingnana
 * @create 12/14/20
 */
public class InitialOrderTest {
    public static String staticFiled="静态变量";
    public String filed="普通成员变量";

    /** 静态初始化快*/
    static {
        System.out.println(staticFiled);
        System.out.println("静态初始化块");
    }

    /** 初始化快*/
    {
        System.out.println(filed);
        System.out.println("初始化块");
    }

    public InitialOrderTest(){
        System.out.println("构造器");
    }

    public static void main(String[] args) {
        new InitialOrderTest();
    }
}
