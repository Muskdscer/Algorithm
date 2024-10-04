package com.example.algorithm.backtracking;

public class SolveSudoku {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    private boolean solveSudokuHelper(char[][] board){
        for (int i = 0; i < 9; i++) {//遍历行
            for (int j = 0; j < 9; j++) {//遍历列
                if (board[i][j] != '.') {//跳过原始数字
                    continue;
                }

                for (char k = '1'; k <= '9'; k++) {//(i,j)这个位置放置k是否合适
                    if (isValidSudoku(i,j,k,board)) {
                        board[i][j] = k;
                        if (solveSudokuHelper(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValidSudoku(int row, int col, char val, char[][] board){
        //同行是否重复
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }
        
        //同列是否重复
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) {
                return false;
            }
        }

        //9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
