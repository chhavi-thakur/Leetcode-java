 public class Solution {
    public int lastRemaining(int n) {
        int left = 1;            
        int step = 1;           
        boolean leftToRight = true;
        int remaining = n;

        while (remaining > 1) {
             if (leftToRight || remaining % 2 == 1) {
                left += step;
            }

            step *= 2;                 
            remaining /= 2;            
             leftToRight = !leftToRight;  
        }

        return left;
    }

    
}
