package com.nana.studyjavarepo.leetcode.editor.cn;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9338 👎 0

//两数之和

import java.util.HashMap;
import java.util.Map;

public class P1_TwoSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1_TwoSum().new Solution();
        int[] nums = {2, 7, 11, 15};
        int[] result=solution.twoSum(nums,9);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {

            Map<Integer, Integer> resultMap = new HashMap<>();
            int[] indexs = new int[2];
            for (int i = 0; i < nums.length; i++) {
                if (resultMap.containsKey(nums[i])) {
                    indexs[0] = i;
                    indexs[1] = resultMap.get(nums[i]);
                    break;
                }
                int tmp = target - nums[i];
                resultMap.put(tmp,i);
            }
            return indexs;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}