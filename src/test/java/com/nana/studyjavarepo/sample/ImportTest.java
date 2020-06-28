package com.nana.studyjavarepo.sample;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Import动态导入一批Bean
 *
 * @author xingnana
 * @create 2020-06-28
 */
public class ImportTest {

    @Test
    public void testImport(){
        ApplicationContext context=new AnnotationConfigApplicationContext(MyConfiguration.class);
        Student student=context.getBean(Student.class);
        System.out.println(student.toString());
    }
}
