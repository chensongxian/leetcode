package largest_rectangle_in_histogram;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Description:
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * @author: lucachen
 * @Date: 2021-04-16
 */
public class Solution {
    /**
     * 暴力破解
     * 会超时时间 n^2
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for ( int j = i; j >= 0; j--) {
                minHeight = Math.min(heights[j], minHeight);
                int area = (Math.abs(j - i) + 1) * minHeight;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
            minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(heights[j], minHeight);
                int area = (Math.abs(j - i) + 1) * minHeight;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    /**
     * 单调栈
     * 时间复杂度 n
     * 空间复杂度 n
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        int n  = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> incrStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!incrStack.isEmpty() && heights[incrStack.peek()] >= heights[i]) {
                incrStack.pop();
            }
            left[i] = incrStack.isEmpty() ? -1 : incrStack.peek();
            incrStack.push(i);
        }
        incrStack.clear();
        for (int i = n -1; i >= 0; i--) {
            while (!incrStack.isEmpty() && heights[incrStack.peek()] >= heights[i]) {
                incrStack.pop();
            }
            right[i] = incrStack.isEmpty() ? n : incrStack.peek();
            incrStack.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (right[i] - left[i] - 1) * heights[i]);
        }
        return maxArea;
    }

    /**
     * 单调栈+常数优化
     * 左右边界一次循环
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int n  = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        Deque<Integer> incrStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!incrStack.isEmpty() && heights[incrStack.peek()] >= heights[i]) {
                right[incrStack.peek()] = i;
                incrStack.pop();
            }
            left[i] = incrStack.isEmpty() ? -1 : incrStack.peek();
            incrStack.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (right[i] - left[i] - 1) * heights[i]);
        }
        return maxArea;
    }
}
