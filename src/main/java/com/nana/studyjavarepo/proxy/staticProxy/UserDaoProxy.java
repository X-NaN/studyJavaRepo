package com.nana.studyjavarepo.proxy.staticProxy;


import com.nana.studyjavarepo.proxy.IUserDao;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/12/21  15:30
 * Description:静态代理
 * Modified By:
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
