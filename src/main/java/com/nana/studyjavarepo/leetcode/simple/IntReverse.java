package com.nana.studyjavarepo.leetcode.simple;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 *
 * @author xingnana
 * @create 2020-07-20
 */
public class IntReverse {
    /**
     * 技巧型
     * 耗时最少
     * @param x
     * @return
     */
    public int reverse(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }

    public int reverse1(int x) {
        String xString = String.valueOf(x);
        String tmp=xString;
        int flag=1;
        if(x<0){
           flag=-1;
           tmp=xString.substring(1);
        }
        try{
            return Integer.valueOf(new StringBuilder(tmp).reverse().toString())*flag;
        }catch (Exception e){
            return 0;
        }

    }

    public static void main(String[] args) {
        IntReverse intReverse=new IntReverse();
        System.out.println(intReverse.reverse1(123));
    }
}
