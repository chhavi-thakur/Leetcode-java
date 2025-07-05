 public class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if (!wordSet.contains(endWord)) return result;

         Map<String, List<String>> graph = new HashMap<>();
          Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);

         Set<String> visited = new HashSet<>();
        boolean foundEnd = false;

        while (!currentLevel.isEmpty() && !foundEnd) {
            Set<String> nextLevel = new HashSet<>();
            for (String word : currentLevel) visited.add(word);

            for (String word : currentLevel) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        chars[i] = c;
                        String newWord = new String(chars);

                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            if (newWord.equals(endWord)) foundEnd = true;

                            graph.computeIfAbsent(newWord, k -> new ArrayList<>()).add(word);
                            nextLevel.add(newWord);
                        }
                    }
                    chars[i] = original;
                }
            }
            currentLevel = nextLevel;
        }

        if (foundEnd) {
            LinkedList<String> path = new LinkedList<>();
            path.add(endWord);
            dfs(endWord, beginWord, graph, path, result);
        }

        return result;
    }

    private void dfs(String word, String beginWord, Map<String, List<String>> graph,
                     LinkedList<String> path, List<List<String>> result) {
        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }

        if (!graph.containsKey(word)) return;

        for (String prev : graph.get(word)) {
            path.addLast(prev);
            dfs(prev, beginWord, graph, path, result);
            path.removeLast();
        }
    }

    
}
