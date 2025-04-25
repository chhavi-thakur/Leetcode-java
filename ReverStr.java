public class ReverStr {
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[] input = {'h', 'e', 'l', 'l', 'o'};

        sol.reverseString(input);

        System.out.print("Reversed string: ");
        for (char c : input) {
            System.out.print(c);
        }
        System.out.println(); // for newline
    }
}

class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
