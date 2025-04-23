public class FindDiff {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abcd";
        String t = "abcde";
        char result = sol.findTheDifference(s, t);
        System.out.println("The extra character is: " + result);  // Output: e
    }
}

class Solution {
    public char findTheDifference(String s, String t) {
        int sumS = 0, sumT = 0;

        // Sum ASCII values of both strings
        for (char c : s.toCharArray()) {
            sumS += c;
        }

        for (char c : t.toCharArray()) {
            sumT += c;
        }

        // The difference is the extra character
        return (char)(sumT - sumS);
    }
}
