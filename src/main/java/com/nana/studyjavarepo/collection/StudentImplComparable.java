package com.nana.studyjavarepo.collection;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/11/30  11:48
 * Description:
 * Modified By:
 */
public class StudentImplComparable implements Comparable<StudentImplComparable> {

    private int id;
    private String name;
    private int age;
    private int score;

    public StudentImplComparable(int id, String name, int age, int score) {
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

    /**
     * 排序规则
     * 1.根据分数排序 默认是升序
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(StudentImplComparable o) {

        //升序
        int i = this.score - o.score;
        //降序
        //int i=o.score-this.score;
        return i;
    }
}
