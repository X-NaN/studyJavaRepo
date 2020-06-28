package com.nana.studyjavarepo.sample;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 功能描述 <br>
 *
 * @author xingnana
 * @create 2020-06-28
 */
@Component
public class Student {
    @Value("mike")
    private String name;

    @Value("18")
    private String age;

    @Value("male")
    private String sex;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
