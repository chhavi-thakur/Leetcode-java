 
public class  Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;

             while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length(); // 1 for space
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int numWords = last - index;
            int numSpaces = maxWidth - totalChars + (numWords - 1);

            if (last == words.length || numWords == 1) {
                 for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i != last - 1) sb.append(" ");
                }
                int remaining = maxWidth - sb.length();
                while (remaining-- > 0) sb.append(" ");
            } else {
                 int spaces = (maxWidth - (totalChars - (numWords - 1))) / (numWords - 1);
                int extra = (maxWidth - (totalChars - (numWords - 1))) % (numWords - 1);

                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i != last - 1) {
                        int spaceToApply = spaces + (extra-- > 0 ? 1 : 0);
                        for (int s = 0; s < spaceToApply; s++) sb.append(" ");
                    }
                }
            }

            result.add(sb.toString());
            index = last;
        }

        return result;
    }

     }
