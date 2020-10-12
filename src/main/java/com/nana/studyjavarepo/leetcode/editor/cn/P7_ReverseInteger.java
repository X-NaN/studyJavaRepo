package com.nana.studyjavarepo.leetcode.editor.cn;
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2251 👎 0

//整数反转

import java.util.ArrayList;
import java.util.List;

public class P7_ReverseInteger {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P7_ReverseInteger().new Solution();
        System.out.println( solution.reverse(-450));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            List<Integer> integers = new ArrayList<>();
            boolean flag = x > 0 ? true : false;
            x = x > 0 ? x : -x;
            while (x > 0) {
                int num = x % 10;// 取个位数
                integers.add(num);
                x = x / 10;// 除10，退一位
            }
            System.out.println(integers);

            int sum = integers.get(0) * 10 + integers.get(1);
            int count = 1;
            while (count < integers.size() - 1) {
                sum = sum * 10 + integers.get(count + 1);
                count++;
            }
            if (!flag) {
                sum = (-1) * sum;
            }

            if (sum < Math.pow(2, 31) - 1 && sum > (-1) * Math.pow(2, 31)){
                return sum;
            }

            return 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}