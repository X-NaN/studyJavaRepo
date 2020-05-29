package com.nana.studyjavarepo.lambada;

import com.nana.studyjavarepo.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 函数式接口Predicate
 * Predicate接口适合做过滤，允许单个或多个条件过滤
 * https://juejin.im/post/5abc9ccc6fb9a028d6643eea#heading-3
 *
 * @author xingnana
 * @create 2020-05-26
 */
public class PredicateDemo {
    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("1", "lily", "female", 20));
        userList.add(new User("2", "lucy", "female", 20));
        userList.add(new User("3", "lucy", "male", 25));
        userList.add(new User("4", "jack", "male", 17));
        userList.add(User.builder().userId("6").userName("jack").gender("female").age(22).build());
        userList.add(User.builder().userId("7").userName("apollo").gender("male").age(16).build());

    }

    public static void main(String[] args) {
        System.out.println("过滤name以j开头的");
        filter(userList, (user) -> ((User) user).getUserName().startsWith("j"));

        System.out.println("过滤age>=20的");
        filter(userList, (user) -> ((User) user).getAge() >= 20);

        System.out.println("过滤age>=20的");
        filterPlus(userList, (user) -> ((User) user).getAge() >= 20);

        System.out.println("and多个条件:");
        Predicate<User> ageBigThan=user -> user.getAge()>=20;
        Predicate<User> female=user -> user.getGender()=="female";
        userList.stream().filter(ageBigThan.and(female)).forEach(user -> System.out.println("user=>"+user));

    }

    /**
     * 定制过滤
     *
     * @param users
     * @param condition
     */
    public static void filter(List<User> users, Predicate condition) {
        for (User user : users) {
            if (condition.test(user)) {
                System.out.println("user=>" + user);
            }
        }
    }

    /**
     *  定制过滤
     * @param users
     * @param condition
     */
    public static void filterPlus(List<User> users, Predicate condition) {
        users.stream().filter(user -> (condition.test(user))).forEach(user -> System.out.println("user=>" + user));
    }

}
