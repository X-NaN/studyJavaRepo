package com.nana.studyjavarepo.proxy.staticProxy;


import com.nana.studyjavarepo.proxy.IUserDao;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/12/21  15:30
 * Description:静态代理
 * 这种代理方式需要代理对象和目标对象实现一样的接口。
 *
 * 优点：可以在不修改目标对象的前提下扩展目标对象的功能。
 * 缺点：
 * 冗余。由于代理对象要实现与目标对象一致的接口，会产生过多的代理类。
 * 不易维护。一旦接口增加方法，目标对象与代理对象都要进行修改。
 */
public class UserDaoProxy implements IUserDao {
    //接收保存目标对象
    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {

        System.out.println("开启事务...");
        //执行目标对象的方法(接口回调)
        target.save();
        System.out.println("提交事务...");

    }
}
