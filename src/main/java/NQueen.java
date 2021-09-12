import java.util.ArrayList;
import java.util.Arrays;

public class NQueen {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    char[][] board = new char[n][n];
    for(char[] row:board){
      Arrays.fill(row, '.');
    }

    backtrack(res, n, 0, board);
    return res;

  }

  void backtrack(List<List<String>> res, int n, int row, char[][] board){
    if( row == n){
      List<String> list = new ArrayList<>();
      for(char[] r:board){
        list.add(new String(r));
      }
      res.add(list);
      return;
    }
    for(int i = 0; i < n; i++){
      if(!valid(row, i, board, n)){
        continue;
      }
      board[row][i] = 'Q';
      backtrack(res, n, row + 1, board);
      board[row][i] = '.';
    }

  }

  boolean valid(int row, int i, char[][] board, int n){
    for(int j = 0; j <= row-1; j++){
      if(board[j][i] == 'Q'){
        return false;
      }
    }
    for(int j = row-1 ,  k = i+1; j >= 0 && k < n; j--, k++){
      if(board[j][k] == 'Q'){
        return false;
      }
    }
    for(int j = row-1,  k = i-1; j >= 0 && k>=0; j--, k--){
      if(board[j][k] == 'Q'){
        return false;
      }
    }
    return true;
  }

}
