import java.util.*;

public class KthSmallestElement {
    
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = lessEqual(matrix, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int lessEqual(int[][] matrix, int target) {
        int count = 0, len = matrix.length, i = len - 1, j = 0;

        while (i >= 0 && j < len) {
            if (matrix[i][j] > target) {
                i--;
            } else {
                count += i + 1;
                j++;
            }
        }
        return count;
    }

    // Main method for testing
    public static void main(String[] args) {
        KthSmallestElement sol = new KthSmallestElement();

        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int k = 8;

        int result = sol.kthSmallest(matrix, k);
        System.out.println("The " + k + "th smallest element is: " + result);
    }
}
