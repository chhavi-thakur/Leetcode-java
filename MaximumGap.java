 public class Solution {

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

         for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) return 0; 
        int n = nums.length;
        int bucketSize = (int) Math.ceil((double)(max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] bucketUsed = new boolean[bucketCount];

         for (int num : nums) {
            int bucketIndex = (num - min) / bucketSize;
            if (!bucketUsed[bucketIndex]) {
                bucketUsed[bucketIndex] = true;
                bucketMin[bucketIndex] = num;
                bucketMax[bucketIndex] = num;
            } else {
                bucketMin[bucketIndex] = Math.min(bucketMin[bucketIndex], num);
                bucketMax[bucketIndex] = Math.max(bucketMax[bucketIndex], num);
            }
        }

         int maxGap = 0;
        int previousMax = min;

        for (int i = 0; i < bucketCount; i++) {
            if (!bucketUsed[i]) continue;
            maxGap = Math.max(maxGap, bucketMin[i] - previousMax);
            previousMax = bucketMax[i];
        }

        return maxGap;
    }
}
