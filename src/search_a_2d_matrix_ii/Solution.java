package search_a_2d_matrix_ii;

/**
 * @Description:
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * 搜索二维矩阵 II
 * @author: lucachen
 * @Date: 2021-03-08
 */
public class Solution {
    /**
     * 暴力破解
     * 时间复杂度：O（n * m）
     * 空间复杂度：O (1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] ==  target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 双指针
     * 时间复杂度：O(n+m)
     * 空间复杂度：O(1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        for (int i = 0, j = matrix[0].length - 1; i < matrix.length && j >= 0;) {
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }


}
