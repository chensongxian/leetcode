package container_with_most_water;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2021-03-06
 */
public class Solution {

    public int maxArea(int[] height) {
        return maxArea1(height);
    }

    /**
     * 最简单：暴力循环
     * 可能会超时
     *
     * 时间复杂度：O(n^2)
     * 空间复杂的：O(1)
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    /**
     * 双指针法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * 正确性验证：https://leetcode-cn.com/problems/container-with-most-water/solution/on-shuang-zhi-zhen-jie-fa-li-jie-zheng-que-xing-tu/
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int minHeight = height[i] <= height[j] ? height[i++] : height[j--];
            // 已经减去1，需要再加上1
            int area = (j - i + 1) * minHeight;
            max = Math.max(max, area);
        }
        return max;
    }
}
