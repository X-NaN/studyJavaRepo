package com.nana.studyjavarepo.proxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/12/21  16:53
 * Description:动态代理——Cglib子类代理工厂
 * Cglib是一个强大的高性能的代码生成包,它可以在运行期扩展java类与实现java接口.
 * Modified By:
 */
public class ProxyFactory {

    //目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 为目标对象创建一个代理对象
     *
     * @return 子类对象
     */
    public Object getProxyInstance() {
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(new MethodInterceptor() {
            /**
             *
             * @param o
             * @param method 目标对象方法
             * @param objects 方法参数
             * @param methodProxy
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("开启事务...");
                Object returnValue = method.invoke(target, objects);
                System.out.println("提交事务...");
                return returnValue;
            }
        });

        //4.创建target类的子类（也是代理对象）
        return en.create();
    }


}
