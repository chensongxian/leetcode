package moveZeroes;

/**
 * @Description:
 * leetcode 283. 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 * @author: lucachen
 * @Date: 2021-02-23
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 ) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}