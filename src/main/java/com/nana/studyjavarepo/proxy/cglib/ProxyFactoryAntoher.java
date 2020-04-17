package com.nana.studyjavarepo.proxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/12/21  17:08
 * Description:动态代理——Cglib子类代理工厂
 * <p>
 * Modified By:
 */
public class ProxyFactoryAntoher implements MethodInterceptor {

    private Object target;

    public ProxyFactoryAntoher(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);

        //4.创建target类的子类(代理对象)
        return en.create();
    }

    /**
     * @param o           代理对象
     * @param method      目标对象方法
     * @param objects     目标对象方法参数
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
}
