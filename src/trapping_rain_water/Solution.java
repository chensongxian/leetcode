package trapping_rain_water;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description: TODO
 * @author: lucachen
 * @Date: 2021-04-18
 */
public class Solution {
    /**
     * 单调栈
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        Deque<Integer> descStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!descStack.isEmpty() && height[descStack.peek()] < height[i]) {
                Integer top = descStack.pop();
                if (descStack.isEmpty()) {
                    break;
                }
                int left  = descStack.peek();
                int width = i - top;
                ans += (Math.min(height[left], height[i]) - height[top]) * width;
            }
            descStack.push(i);
        }
        return ans;
    }

    /**
     * 暴力破解
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int ans = 0;
        int n = height.length;
        for (int i = 1; i < n -1; i++) {
           int maxLeft = 0, maxRight = 0;
           for (int j = i; j >= 0; j--) {
               maxLeft = Math.max(maxLeft, height[j]);
           }
           for (int j = i; j < n; j ++) {
               maxRight = Math.min(maxRight, height[j]);
           }
           ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }
}
