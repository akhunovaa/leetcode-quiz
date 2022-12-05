package interview.array.matrix;

public class WordSearch {

    public static void main(String[] args) {
        char[][] boardOne = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        char[][] boardTwo = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String wordOne = "ABCCED";
        String wordTwo = "SEE";
        String wordThree = "ABCB";

        boolean answer = exist(boardTwo, wordOne);
        System.out.println("Answer: " + answer);
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        int idx = 0;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (word.charAt(idx) == board[row][col]) {
                    if (DFS(idx, row, col, board, word)) return true;
                }
            }
        }
        return false;
    }

    private static boolean DFS(int idx, int row, int col, char[][] board, String word) {
        if (idx == word.length()) return true;
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
        boolean res = false;
        if (word.charAt(idx) == board[row][col]) {
            board[row][col] = '.';
            res = DFS(idx + 1, row + 1, col, board, word)
                    || DFS(idx + 1, row - 1, col, board, word)
                    || DFS(idx + 1, row, col + 1, board, word)
                    || DFS(idx + 1, row, col - 1, board, word);
            board[row][col] = word.charAt(idx);
        }
        return res;
    }

}
