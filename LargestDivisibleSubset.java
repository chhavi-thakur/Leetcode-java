import java.util.*;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);

        int maxSize = 1, maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        if (dp[i] > maxSize) {
                            maxSize = dp[i];
                            maxIndex = i;
                        }
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int num = nums[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if (num % nums[i] == 0 && dp[i] == maxSize) {
                result.add(nums[i]);
                num = nums[i];
                maxSize--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset obj = new LargestDivisibleSubset();
        int[] nums = {1, 2, 4, 8};
        List<Integer> subset = obj.largestDivisibleSubset(nums);
        System.out.println("Largest Divisible Subset: " + subset);
    }
}
