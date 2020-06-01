package com.nana.studyjavarepo.proxy;

import com.nana.studyjavarepo.proxy.cglib.ProxyFactory;
import com.nana.studyjavarepo.proxy.cglib.ProxyFactoryAntoher;
import com.nana.studyjavarepo.proxy.staticProxy.UserDaoProxy;
import org.junit.jupiter.api.Test;

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

        userDaoProxy.save();
    }

    /**
     * JDK动态代理测试
     */
    @Test
    public void testDynamicProxy() {
        IUserDao target = new UserDao();
        // 目标对象信息
        System.out.println(target.getClass());
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // 代理对象信息
        System.out.println(proxy.getClass());

        proxy.save();
    }

    @Test
    public void testCglibProxy(){
        UserDao target=new UserDao();
        System.out.println(target.getClass());

        UserDao proxy=(UserDao) new ProxyFactoryAntoher(target).getProxyInstance();

        System.out.println(proxy.getClass());
        proxy.save();
    }


}
