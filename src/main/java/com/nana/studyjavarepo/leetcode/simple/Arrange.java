package com.nana.studyjavarepo.leetcode.simple;

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

    public static void main(String[] args) {
        String s = "AAB";
        arrange(s.toCharArray(), 0);
    }

}
