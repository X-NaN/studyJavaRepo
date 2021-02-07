package com.nana.studyjavarepo.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * UserDao调用处理器
 *
 * @author xingnana
 * @create 2/7/21
 */
public class UserDaoInvocationHandler implements InvocationHandler {

    /**
     * 被代理的对象
     */
    private Object target;

    public UserDaoInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 处理动态代理类上的所有方法调用
     * 本调用处理器根据这三个参数 进行预处理或分派到委托类实例上「反射」执行
     *
     * @param proxy  代理类
     * @param method 被调用的方法对象
     * @param args   方法入参
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开启事务...");
        Object returnValue = method.invoke(proxy, args);
        System.out.println("提交事务...");

        return returnValue;
    }
}
