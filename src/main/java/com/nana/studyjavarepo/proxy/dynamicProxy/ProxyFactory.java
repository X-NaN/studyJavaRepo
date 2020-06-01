package com.nana.studyjavarepo.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/12/21  16:25
 * Description: 动态代理(又称JDK代理,接口代理)——代理工厂
 * 总结：代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理
 * 静态代理与动态代理的区别主要在：
 *
 * 静态代理在编译时就已经实现，编译完成后代理类是一个实际的class文件
 * 动态代理是在运行时动态生成的，即编译完成后没有实际的class文件，而是在运行时动态生成类字节码，并加载到JVM中
 * 特点：
 * 动态代理对象不需要实现接口，但是要求目标对象必须实现接口，否则不能使用动态代理。
 */
public class ProxyFactory {

    //维护一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 动态创建代理对象
     *
     * @return
     */
    public Object getProxyInstance() {
        // 指定目标对象使用的类加载器/目标对象的接口/事件处理器
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            /**
             *   该方法invoke被执行几次？------- 看代理对象调用方法几次
             *   代理对象调用接口相应方法 都是调用invoke
             * @param proxy 代理对象
             * @param method 目标方法的字节码对象
             * @param args 调用目标方法时的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开启事务...");
                //运用反射执行目标对象方法
                Object returnValue = method.invoke(target, args);
                System.out.println("提交事务...");
                return returnValue;
            }
        });
    }

}
