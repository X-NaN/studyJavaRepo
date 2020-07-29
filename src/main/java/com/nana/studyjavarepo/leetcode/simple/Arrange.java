package com.nana.studyjavarepo.leetcode.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 排列
 *
 * @author xingnana
 * @create 2020-07-29
 */
public class Arrange {
    public static void swap(int i, int j, char[] arr) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 全排列
     * 思想：
     * 如ABC
     * 第0位，跟第自己换，跟第1位换，跟第n-1位换。[A]BC ->ABC,BAC,CBA
     * --》A[B]C 第自己换，跟C换，A[B]C->ABC,ACB
     *
     * @param arr
     * @param index
     */
    public static void arrange(char[] arr, int index) {

        if (index == arr.length) {
            System.out.println(arr);
        }

        for (int i = index; i < arr.length; i++) {
            /** 过滤调重复的交换，如AAB,第一个A和第二个A交换，交换后结果没变*/
            if (i != index && arr[i] == arr[index]) {
                continue;
            }
            /** 第index位置，依次跟后面的交换*/
            swap(index, i, arr);
            arrange(arr, index + 1);
            /** 再换回去*/
            swap(index, i, arr);
        }
    }

    /**
     * 深拷贝
     *
     * @param data
     * @return
     */
    private static List<String> copy(List<String> data) {
        List<String> newData = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            newData.add(data.get(i));
        }

        return newData;
    }


    /**
     * 全排列
     * 插入
     *
     * @param arr
     * @return
     */
    public static List<List<String>> arrange1(List<String> arr) {
        if (arr.size() == 1) {
            List list = new ArrayList();
            list.add(arr);
            return list;
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            List<String> dataTmp = copy(arr);
            dataTmp.remove(i);
            String a = arr.get(i);
            List tmp = arrange1(dataTmp);
            for (int j = 0; j < tmp.size(); j++) {
                List<String> sList = (List<String>) tmp.get(j);
                sList.add(0, a);
                result.add(sList);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        String s = "AAB";
        arrange(s.toCharArray(), 0);
        System.out.println("==============");
        List<String> s1 = new ArrayList<>();
        s1.add("A");
        s1.add("B");
        s1.add("C");
        System.out.println(arrange1(s1));
    }

}
