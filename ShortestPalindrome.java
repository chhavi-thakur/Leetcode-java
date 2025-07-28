 public class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;

        int[] lps = computeLPSArray(combined);
        int palindromeLength = lps[lps.length - 1];

        String suffix = s.substring(palindromeLength);
        String prefixToAdd = new StringBuilder(suffix).reverse().toString();

        return prefixToAdd + s;
    }

    private int[] computeLPSArray(String s) {
        int[] lps = new int[s.length()];
        int len = 0;
        int i = 1;

        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i] = ++len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

     
}
