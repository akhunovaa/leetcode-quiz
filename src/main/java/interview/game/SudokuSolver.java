package interview.game;

import java.util.*;

public class SudokuSolver {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.',     '.', '7', '.',       '.', '.', '.'},
                {'6', '.', '.',     '1', '9', '5',       '.', '.', '.'},
                {'.', '9', '8',     '.', '.', '.',       '.', '6', '.'},

                {'8', '.', '.',     '.', '6', '.',      '.', '.', '3'},
                {'4', '.', '.',     '8', '.', '3',      '.', '.', '1'},
                {'7', '.', '.',     '.', '2', '.',      '.', '.', '6'},

                {'.', '6', '.',     '.', '.', '.',      '2', '8', '.'},
                {'.', '.', '.',     '4', '1', '9',      '.', '.', '5'},
                {'.', '.', '.',     '.', '8', '.',      '.', '7', '9'}
        };
        solveSudoku(board);
        System.out.println("Answer: ");
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            System.out.println(Arrays.toString(chars));
        }
    }


    static void solveSudoku(char[][] board) {
        List<Cell> emptyCells = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    emptyCells.add(new Cell(i, j));
                }
            }
        }
        solveSudokuFrom(board, emptyCells, 0);
    }

    private static boolean solveSudokuFrom(char[][] board, List<Cell> emptyCells, int curIdx) {
        if (curIdx == emptyCells.size()) {
            return true;
        }
        Cell curCell = emptyCells.get(curIdx);
        Set<Integer> impossibleValues = getImpossibleValues(curCell.x, curCell.y, board);
        for (char i = '1'; i <= '9'; i++) {
            if (impossibleValues.contains(i - '0')) {
                continue;
            }
            board[curCell.x][curCell.y] = i;
            if (solveSudokuFrom(board, emptyCells, curIdx + 1)) {
                return true;
            }
            impossibleValues.add(i - '0');
            board[curCell.x][curCell.y] = '.';
        }
        return false;
    }

    private static Set<Integer> getImpossibleValues(int x, int y, char[][] board) {
        Set<Integer> impossibleValues = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == '.') {
                continue;
            }
            impossibleValues.add(board[i][y] - '0');
        }
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == '.') {
                continue;
            }
            impossibleValues.add(board[x][i] - '0');
        }
        int si = getBoundary(x);
        int sj = getBoundary(y);
        for (int i = si; i <= si + 2; i++) {
            for (int j = sj; j <= sj + 2; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                impossibleValues.add(board[i][j] - '0');
            }
        }
        return impossibleValues;
    }

    private static int getBoundary(int val) {
        if (val >= 0 && val <= 2) {
            return 0;
        }
        if (val >= 3 && val <= 5) {
            return 3;
        }
        return 6;
    }

    static class Cell {
        int x, y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
