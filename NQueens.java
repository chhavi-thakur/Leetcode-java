

public class Solution{
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize the board with '.'
        for (char[] row : board)
            Arrays.fill(row, '.');

        backtrack(solutions, board, 0, n);
        return solutions;
    }

    private void backtrack(List<List<String>> solutions, char[][] board, int row, int n) {
        if (row == n) {
            solutions.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(solutions, board, row + 1, n);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        // Check vertical column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q')
                return false;

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }

    private List<String> constructBoard(char[][] board) {
        List<String> currentBoard = new ArrayList<>();
        for (char[] row : board)
            currentBoard.add(new String(row));
        return currentBoard;
    }

    

}
