public class ThirdMax {
    public int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;

        for (int num : nums) {
            if (num == max1 || num == max2 || num == max3) continue;
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }

        return max3 != Long.MIN_VALUE ? (int) max3 : (int) max1;
    }

    public static void main(String[] args) {
        ThirdMax obj = new ThirdMax();
        
        // Example 1
        int[] nums1 = {3, 2, 1};
        System.out.println("Third max: " + obj.thirdMax(nums1)); // Output: 1

        // Example 2
        int[] nums2 = {1, 2};
        System.out.println("Third max: " + obj.thirdMax(nums2)); // Output: 2

        // Example 3
        int[] nums3 = {2, 2, 3, 1};
        System.out.println("Third max: " + obj.thirdMax(nums3)); // Output: 1
    }
}
