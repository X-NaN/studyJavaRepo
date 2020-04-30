package com.nana.studyjavarepo.lambada;

import java.util.HashMap;
import java.util.Map;

/**
 * Map 应用lambada
 *
 * @author xingnana
 * @create 2020-04-30
 */
public class MapLambadaDemo {
    private static Map<String, Integer> itemMap = new HashMap<>();

    static {
        itemMap.put("aa", 1);
        itemMap.put("bb", 2);
        itemMap.put("cc", 3);
        itemMap.put("dd", 4);
        itemMap.put("ee", 5);
    }

    public static void main(String[] args) {
        System.out.println("Java8前 遍历Map");
        for (Map.Entry<String, Integer> entry : itemMap.entrySet()) {
            System.out.println(String.format("key:%s, value:%s", entry.getKey(), entry.getValue()));
        }

        System.out.println("lambada遍历Map");
        itemMap.forEach((key,value)-> System.out.println(String.format("key:%s, value:%s", key, value)));
    }
}
