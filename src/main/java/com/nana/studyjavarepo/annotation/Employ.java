package com.nana.studyjavarepo.annotation;

import lombok.Data;

/**
 * 员工实体类
 *
 * @author xingnana
 * @create 2020-04-17
 */
@Data
public class Employ {

    @EmployeeName("nana")
    private String name;

    @EmployeeSex(employeeSex = EmployeeSex.Sex.Woman)
    private String sex;

    @Company(id = 1,name = "tuya",address = "hz")
    private String company;

}
