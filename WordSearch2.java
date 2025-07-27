 
public class Solution {
    
     static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;  
    }

     private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                node = node.children.computeIfAbsent(ch, c -> new TrieNode());
            }
            node.word = word; // mark the complete word
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                backtrack(board, i, j, root, result);
            }
        }

        return result;
    }

     private void backtrack(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char ch = board[i][j];
        if (!node.children.containsKey(ch)) return;

        TrieNode nextNode = node.children.get(ch);
        if (nextNode.word != null) {
            result.add(nextNode.word);        
            nextNode.word = null;             
        }

        board[i][j] = '#';  

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};  
        for (int[] dir : directions) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length && board[ni][nj] != '#') {
                backtrack(board, ni, nj, nextNode, result);
            }
        }

        board[i][j] = ch;  
         if (nextNode.children.isEmpty()) {
            node.children.remove(ch);
        }
    }
}
