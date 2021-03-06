package moveZeroes;

import javax.swing.plaf.SliderUI;
import java.lang.reflect.Modifier;

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

    /**
     * 双指针，左指针指向已经处理好序列维度，右指针指向待处理序列
     * 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
     * 每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变
     *
     * 此法存在一个问题，当left = right 时，会发生自己和自己交换
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        // 0,1,0,3,12
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    /**
     * 两次遍历，把非0往前移, 剩余元素都是0，再次循环把剩余元素赋值为0
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        // j 后面序列赋0
        while (j < nums.length) {
            nums[j] = 0;
        }
    }

    public void moveZeroes4(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int j = 0;
        // 1 0 4 2 0 5
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{0,1,0,3,12};
        solution.moveZeroes2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}