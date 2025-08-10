 public class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
             if (nums[i] == 0) continue;
            
            int slow = i, fast = i;
             boolean forward = nums[i] > 0;
            
            while (true) {
                 slow = nextIndex(nums, forward, slow);
                if (slow == -1) break;
                
                 fast = nextIndex(nums, forward, fast);
                if (fast == -1) break;
                fast = nextIndex(nums, forward, fast);
                if (fast == -1) break;
                
                 if (slow == fast) return true;
            }
            
             int index = i;
            int dir = nums[i];
            while (nums[index] != 0 && (nums[index] > 0) == (dir > 0)) {
                int next = ((index + nums[index]) % n + n) % n;
                nums[index] = 0;
                index = next;
            }
        }
        return false;
    }
    
    private int nextIndex(int[] nums, boolean forward, int current) {
        int n = nums.length;
        boolean dir = nums[current] > 0;
         if (dir != forward) return -1;
        
        int next = ((current + nums[current]) % n + n) % n;
        
         if (next == current) return -1;
        
        return next;
    }
    
    
}
