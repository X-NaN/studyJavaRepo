package com.nana.studyjavarepo.proxy;

import com.nana.studyjavarepo.proxy.cglib.CglibProxyFactory;
import com.nana.studyjavarepo.proxy.cglib.CglibProxyFactoryAntoher;
import com.nana.studyjavarepo.proxy.dynamicProxy.ProxyFactory;
import com.nana.studyjavarepo.proxy.dynamicProxy.UserDaoInvocationHandler;
import com.nana.studyjavarepo.proxy.staticProxy.UserDaoProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 测试代理类
 *
 * @author xingnana
 * @create 2020-06-01
 */
public class TestProxy {

    /**
     * 静态代理测试
     */
    @Test
    public void testStaticProxy() {
        IUserDao target = new UserDao();
        UserDaoProxy userDaoProxy = new UserDaoProxy(target);
        System.out.println("静态代理userDaoProxy的class:" + userDaoProxy.getClass());
        userDaoProxy.save();
    }

    /**
     * JDK动态代理测试
     */
    @Test
    public void testDynamicProxy() {
        IUserDao target = new UserDao();
        // 第一种方式，ProxyFactory中的InvocationHandler是匿名类
        System.out.println("target对象class:" + target.getClass());
        ProxyFactory proxyFactory = new ProxyFactory(target);
        System.out.println("jdk动态代理proxyFactory的class" + proxyFactory.getProxyInstance().getClass().getName());

        // 第二种方式，实现InvocationHandler接口
        InvocationHandler invocationHandler = new UserDaoInvocationHandler(target);
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class[] interfaces = target.getClass().getInterfaces();
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        System.out.println("jdk动态代理对象userDao的class:" + userDao.getClass().getName());

    }

    @Test
    public void testCglibProxy() {
        UserDao target = new UserDao();
        System.out.println(target.getClass());
        UserDao proxy = (UserDao) new CglibProxyFactoryAntoher(target).getProxyInstance();
        System.out.println("cglib proxy1:" + proxy.getClass());
        proxy.save();

        IUserDao proxy2 = (IUserDao) new CglibProxyFactory(target).getProxyInstance();
        // 代理对象信息
        System.out.println("cglib proxy2:" + proxy2.getClass());
        proxy.save();
    }


}
