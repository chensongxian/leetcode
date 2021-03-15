package two_sum_ii_input_array_is_sorted;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 两数之和 II - 输入有序数组
 * @author: lucachen
 * @Date: 2021-03-08
 */
public class Solution {
    /**
     * 暴力破解
     * O(n^2) 的时间复杂度和 O(1) 的空间复杂度
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if ((numbers[i] + numbers[j]) == target) {
                    answer[0] = i + 1;
                    answer[1] = j + 1;
                    return answer;
                }
            }
        }
        return answer;
    }

    /**
     * 双指针法
     * 时间复杂度：O(n)，其中 n是数组的长度。两个指针移动的总次数最多为 n次。
     *
     * 空间复杂度：O(1)。
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        int[] answer = new int[2];
        for (int i = 0, j = numbers.length -1; i < j;) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                answer[0] = i + 1;
                answer[1] = j + 1;
                return answer;
            }
        }
        return answer;
    }

    /**
     * hash
     * 时间复杂度：O(n)。
     *
     * 空间复杂度：O(n)。
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i ++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return new int[]{0,0};
    }


}
