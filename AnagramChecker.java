import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }
}

public class AnagramChecker {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "listen";
        String t = "silent";

        boolean result = sol.isAnagram(s, t);

        if (result) {
            System.out.println("\"" + s + "\" and \"" + t + "\" are anagrams.");
        } else {
            System.out.println("\"" + s + "\" and \"" + t + "\" are not anagrams.");
        }
    }
}
