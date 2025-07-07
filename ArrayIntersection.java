import java.util.Arrays;

public class ArrayIntersection {

    // Method to find intersection of two arrays
    public int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int i = 0, j = 0, k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i < l1 && j < l2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    // Main method to test the intersect function
    public static void main(String[] args) {
        ArrayIntersection solution = new ArrayIntersection();
        
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        
        int[] result = solution.intersect(nums1, nums2);
        
        System.out.println("Intersection: " + Arrays.toString(result));
    }
}
