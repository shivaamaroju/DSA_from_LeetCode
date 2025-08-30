class Solution {
    public boolean isvalid(char[][] board, int r, int c, char num) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][c] == num)
                return false;
        }
        for (int j = 0; j < board.length; j++) {
            if (board[r][j] == num)
                return false;
        }
        int sr = r / 3 * 3;
        int sc = c / 3 * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char num = board[i][j];
                if (num != '.') {
                    board[i][j] = '.';
                    if (isvalid(board, i, j, num) == false) {
                        return false;
                    }
                    board[i][j] = num;
                }
            }
        }
        return true;
    }
}