package com.nana.studyjavarepo.annotation;

import java.util.Map;

/**
 * 功能描述 <br>
 *
 * @author xingnana
 * @create 2020-04-17
 */
public class AnnoationTest {
    public static void main(String[] args) {
        Map employeeInfo=EmployInfoUtil.getEmployeeInfo(Employ.class);
        System.out.println(employeeInfo);
    }
}
