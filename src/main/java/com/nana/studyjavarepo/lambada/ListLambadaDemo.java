package com.nana.studyjavarepo.lambada;

import com.nana.studyjavarepo.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 列表 应用lambada
 *
 * @author xingnana
 * @create 2020-04-30
 */
public class ListLambadaDemo {
    private static List<User> userList=new ArrayList<>();

    static {
        userList.add(new User("1","lily","female",20));
        userList.add(new User("2","lucy","female",20));
        userList.add(new User("3","jack","male",17));
        userList.add(User.builder().userId("4").userName("jacy").gender("male").age(17).build());
        userList.add(User.builder().userId("5").userName("apollo").gender("male").age(16).build());

    }

    public static void main(String[] args) {
        System.out.println("java8前操作List");
        for(User user:userList){
            System.out.println(user);
        }

        System.out.println("Java8 lambda遍历list");
        userList.forEach(item-> System.out.println(item));

        System.out.println("Java8 lambda遍历list");
        userList.forEach(item->{
            if(item.getGender().equals("male")){
                System.out.println(item);
            }
        });

        System.out.println("先过滤，再遍历");
        userList.stream().filter(item->item.getGender().equals("female")).forEach(item-> System.out.println(item));

        System.out.println("列表分组");
        Map<Integer,List<User>> collectResult=userList.stream().collect(Collectors.groupingBy(item->item.getAge()));
        System.out.println(collectResult);
    }
}
