package com.nana.studyjavarepo.proxy;


/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/12/21  15:29
 * Description:
 * Modified By:
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("数据保存操作");
    }
}
