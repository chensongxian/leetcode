package two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * https://leetcode-cn.com/problems/two-sum/
 * 两数之合
 * @author: lucachen
 * @Date: 2021-03-09
 */
public class Solution {
    /**
     * 暴力破解
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            integerMap.put(nums[i], i);
            if (integerMap.containsKey(target - nums[i])) {
                return new int[]{integerMap.get(target - nums[i]), i};
            }
        }
        return new int[]{};
    }
}
