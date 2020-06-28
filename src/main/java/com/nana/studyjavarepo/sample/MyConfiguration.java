package com.nana.studyjavarepo.sample;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 功能描述 <br>
 *
 * @author xingnana
 * @create 2020-06-28
 */
@Import(MyImportSelector.class)
@Configuration
public class MyConfiguration {

}
