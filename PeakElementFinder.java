public class PeakElementFinder {

    // Method to find the peak element
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // Main method for testing
    public static void main(String[] args) {
        PeakElementFinder finder = new PeakElementFinder();

        int[] nums = {1, 2, 3, 1};
        int peakIndex = finder.findPeakElement(nums);

        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + nums[peakIndex]);
    }
}
