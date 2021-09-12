public class sudoku {
  public void solveSudoku(char[][] board) {
    backtrack(board, 0, 0);


  }

  boolean backtrack(char[][] board, int r, int c){
    if(c == 9){

      return backtrack(board, r+1, 0);
    }
    if(r == 9){
      return true;
    }
    for(int i = r; i < board.length; i++){
      for(int j = c; j < board.length; j++){
        if(board[i][j] != '.'){
          return backtrack(board, i, j+1);
        }
        for(char ch = '1'; ch <= '9'; ch++){
          if(!isValid(board, i, j, ch)){
            continue;
          }
          board[i][j] = ch;
          if(backtrack(board, i, j+1)){
            return true;
          }
          board[i][j] = '.';
        }
        return false;
      }
    }
    return false;

  }

  boolean isValid(char[][] board, int row, int col, char ch){
    for(int i = 0; i < board.length; i++){
      if(board[row][i] == ch){
        return false;
      }
      if(board[i][col] == ch){
        return false;
      }
    }

    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board.length; j++){
        if(i/3 == row/3 && j/3 == col/3 && board[i][j] ==ch){
          return false;
        }
      }
    }

    return true;
  }
}
