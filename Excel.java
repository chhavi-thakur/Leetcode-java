 public class Solution {
    public static String convertToTitle(int columnNumber) {
        StringBuilder columnTitle = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // Adjust to 0-based indexing
            int remainder = columnNumber % 26;
            columnTitle.append((char) ('A' + remainder));
            columnNumber /= 26;
        }

        return columnTitle.reverse().toString();
    }

    }
