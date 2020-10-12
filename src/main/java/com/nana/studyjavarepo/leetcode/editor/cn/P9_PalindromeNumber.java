package com.nana.studyjavarepo.leetcode.editor.cn;
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1265 👎 0

//回文数

import java.util.ArrayList;
import java.util.List;

public class P9_PalindromeNumber {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P9_PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(10));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            List<Integer> nums = new ArrayList<>();
            while (x > 0) {
                nums.add(x % 10);
                x = x / 10;
            }
            boolean flag = true;
            int half = nums.size() / 2;
            int length = nums.size();
            for (int i = 0; i < half; i++) {
                if (!nums.get(i).equals(nums.get(length - 1 - i))) {
                    flag = false;
                    break;
                }
            }

            return flag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}