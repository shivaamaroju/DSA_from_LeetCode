class Solution {
    static int flag=0;
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
    public void solve(char [][]board,int r,int c){
        if(r==9){
            flag=1;return;
        }

    if(board[r][c]!='.'){
        if(c!=8)solve(board,r,c+1);
        else solve(board,r+1,0);
    }
    else{
        for(char ch='1';ch<='9';ch++){
            if(isvalid(board,r,c,ch)){
                board[r][c]=ch;
                if(c!=8)solve(board,r,c+1);
        else solve(board,r+1,0);
    if(flag==1)return;
   board[r][c]='.';
            }
        }
    }
    }
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
        flag=0;
    }
}