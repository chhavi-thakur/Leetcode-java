import java.util.Arrays;

public class CountBits {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int sub = 1;

        for (int i = 1; i <= n; i++) {
            if (sub * 2 == i) {
                sub = i;
            }
            dp[i] = dp[i - sub] + 1;
        }

        return dp;        
    }

    public static void main(String[] args) {
        CountBits sol = new CountBits();
        int n = 5; // Example input
        int[] result = sol.countBits(n);
        System.out.println("Count of 1's in binary representation from 0 to " + n + ":");
        System.out.println(Arrays.toString(result));  // Output: [0, 1, 1, 2, 1, 2]
    }
}
