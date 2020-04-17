package com.nana.studyjavarepo.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/11/30  11:34
 * Description:
 * Modified By:
 */
public class Student {
    private int id;
    private String name;
    public int age;
    public int score;

    public Student() {
        super();
    }

    private Student(int id) {
        this.id = id;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(int id, String name, int age, int score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private Map<String, Object> getIdName() {
        Map<String, Object> data = new HashMap<String, Object>();

        data.put("id", id);
        data.put("name", name);

        return data;
    }

    private void getValue(String value) {
        System.out.println("参数value为:" + value);
    }

    public Map<String, Object> getIdNameAge() {
        Map<String, Object> data = new HashMap<String, Object>();

        data.put("id", id);
        data.put("name", name);
        data.put("age", age);
        return data;
    }

    public void getNameValue(String name, String value) {
        System.out.println("参数name:" + name + "参数value:" + value);
    }

    @Override
    public String toString() {
        return "id:" + id + " name:" + name + " age:" + age + " score:" + score;
    }
}
