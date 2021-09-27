import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class WordSearch {
  public List<String> findWords(char[][] board, String[] words) {
    Set<String> result = new HashSet<>();
    for(String word:words){
      if(result.contains(word)){
        continue;
      }
      for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[0].length; j++){
          char ch = word.charAt(0);
          if(ch == board[i][j] && dfs(board, word,i, j, 0)){
            result.add(word);
          }
        }
      }
    }
    return new LinkedList<>(result);

  }

  private boolean dfs(char[][] board, String word, int i, int j, int w){
    if(w == word.length()){
      return true;
    }

    if(isPossible(board, i, j, word.charAt(w))){
      char temp = board[i][j];
      board[i][j] = 'A';
      if(dfs(board, word, i, j+1, w+1)){
        board[i][j] = temp;
        return true;
      }
      if (dfs(board, word, i, j - 1, w + 1)) {
        board[i][j] = temp;
        return true;
      }
      if (dfs(board, word, i + 1, j, w + 1)) {
        board[i][j] = temp;
        return true;
      }
      if (dfs(board, word, i - 1, j, w + 1)) {
        board[i][j] = temp;
        return true;
      }
      board[i][j] = temp;
    }
    return false;
  }

  private boolean isPossible(char[][] board, int i, int j, char ch) {
    return i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == ch;
  }
}