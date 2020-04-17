package com.nana.studyjavarepo.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * map 相关操作
 *
 * @author xingnana
 * @create 2020-04-11
 */
public class MapOPeration {

    /**
     * 通过
     */
    public static void opEntry(){
        Map<String,String> map=new HashMap<>();
        map.put("1","demo1");
        map.put("2","demo2");
        for(Map.Entry<String,String> entry:map.entrySet()){
            String msg=String.format("key:%s,value:%s",entry.getKey(),entry.getValue());
            System.out.println(msg);
        }
    }


    public static void main(String[] args) {
        MapOPeration.opEntry();
    }
}
