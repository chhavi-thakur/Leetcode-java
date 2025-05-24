public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] alphabets_counter = new int[26];

        for (char c : magazine.toCharArray())
            alphabets_counter[c - 'a']++;

        for (char c : ransomNote.toCharArray()) {
            if (alphabets_counter[c - 'a'] == 0) return false;
            alphabets_counter[c - 'a']--;
        }

        return true;
    }

    public static void main(String[] args) {
        RansomNote obj = new RansomNote();

        String ransomNote = "aabb";
        String magazine = "aabbcc";

        System.out.println("Can construct: " + obj.canConstruct(ransomNote, magazine));  // Output: true

        ransomNote = "aabbc";
        magazine = "aab";

        System.out.println("Can construct: " + obj.canConstruct(ransomNote, magazine));  // Output: false
    }
}
