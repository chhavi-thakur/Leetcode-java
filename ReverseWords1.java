public class ReverseWords {
    public String reverseWords(String s) {
        // Trim the input string to remove leading and trailing spaces
        String[] str = s.trim().split("\\s+");

        // Initialize the output string
        String out = "";

        // Iterate through the words in reverse order
        for (int i = str.length - 1; i > 0; i--) {
            out += str[i] + " ";
        }

        // Append the first word to the output (without trailing space)
        return out + str[0];
    }

    public static void main(String[] args) {
        ReverseWords obj = new ReverseWords();
        String input = "  the sky   is blue  ";
        String result = obj.reverseWords(input);
        System.out.println("Reversed words: \"" + result + "\"");
    }
}
