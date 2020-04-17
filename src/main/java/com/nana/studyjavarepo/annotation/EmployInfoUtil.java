package com.nana.studyjavarepo.annotation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述 <br>
 *
 * @author xingnana
 * @create 2020-04-17
 */
public class EmployInfoUtil {
    public static Map getEmployeeInfo(Class<?> clazz){
        HashMap<String,String> info=new HashMap<>();
        Field[] fields=clazz.getDeclaredFields();
        for(Field field:fields){
            if(field.isAnnotationPresent(EmployeeName.class)){
                EmployeeName employeeName=field.getAnnotation(EmployeeName.class);
                info.put("employeeName",employeeName.value());
            }

            if(field.isAnnotationPresent(EmployeeSex.class)){
                EmployeeSex employeeSex=field.getAnnotation(EmployeeSex.class);
                info.put("employeeSex",employeeSex.employeeSex().toString());
            }

            if(field.isAnnotationPresent(Company.class)){
                Company company=field.getAnnotation(Company.class);
                info.put("company",company.id()+":"+company.name()+":"+company.address());
            }
        }

        return info;
    }
}
