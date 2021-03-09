package climbing_stairs;

/**
 * @Description:
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 爬楼梯
 * @author: lucachen
 * @Date: 2021-03-09
 */
public class Solution {
    /**
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;

    }

    /**
     * 斐波那契数列的公式
     * 时间复杂度：代码中使用的 pow 函数的时空复杂度与 CPU 支持的指令集相关，这里不深入分析
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        double sqrt_5 = Math.sqrt(5);
        double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5), n + 1);
        return (int) (fib_n / fib_n);
    }
}
