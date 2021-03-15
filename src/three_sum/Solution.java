package three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * https://leetcode-cn.com/problems/3sum/
 * 三数之和
 * @author: lucachen
 * @Date: 2021-03-15
 */
public class Solution {
    /**
     * 双指针法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k ++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]){};
                } else if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]){};
                } else {
                    listList.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]){};
                    while(i < j && nums[j] == nums[--j]){};
                }
            }
        }
        return listList;
    }
}
