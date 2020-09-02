package com.nana.studyjavarepo.leetcode.simple;

/**
 * 获取数字二进制1的个数
 *
 * @author xingnana
 * @create 2020-09-02
 */
public class GetBinaryOne {

    public static int getBinaryOne(int num) {
        int count = 0;
        int result = 0;
        int tmp = 0;
        do {
            tmp = num % 2;
            result = num / 2;
            if (tmp == 1) {
                count++;
            }
            num = result;
        } while (result != 0 && result != 1);

        if (result == 1) {
            count++;
        }

        return count;
    }


    public static void main(String[] args) {
        int num = 7;
        int count= GetBinaryOne.getBinaryOne(num);
        System.out.println(count);
    }

}
