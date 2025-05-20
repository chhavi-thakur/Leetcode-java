import java.util.*;

public class WordPattern {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String pattern = "abba";
        String s = "dog cat cat dog";

        boolean result = sol.wordPattern(pattern, s);
        System.out.println("Pattern matches: " + result);  // Output: true
    }
}

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> setOfWords = new HashSet<>();
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        for (int i = 0; i < words.length; i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!words[i].equals(map.get(ch))) return false;
            } else {
                if (setOfWords.contains(words[i])) return false;
                map.put(ch, words[i]);
                setOfWords.add(words[i]);
            }
        }
        return true;
    }
}
