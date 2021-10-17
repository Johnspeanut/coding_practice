import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class WordLadder {

  public static void main(String[] args) {
    WordLadder wordLadder = new WordLadder();
    List<String> list = new LinkedList<>();
    list.add("hot");
    list.add("dot");
    list.add("dog");
    list.add("lot");
    list.add("log");
    list.add("cog");

    int result = wordLadder.ladderLength("hit","cog",list);
    System.out.println("result is"+ result);



  }
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Queue<String> pq = new LinkedList<>();
    // boolean[] visited = new boolean[wordList.length];
    Map<String,Boolean> visited = new HashMap<>();
    pq.offer(beginWord);
    visited.put(beginWord, true);
    // int[] count = new int[wordList.length];
    int count = 0;
    while(!pq.isEmpty()){
       int size = pq.size();
      for(int i = 0; i < size; i++){
        String cur = pq.poll();
        for(String word:wordList){
          if(rativeWords(cur,word) && !visited.containsKey(word)){
            pq.offer(word);
            visited.put(word,true);
            if(word.equals(endWord)){
              return count+1;
            }

          }
        }
      }
      count++;
    }
    return 0;

  }

  public boolean rativeWords(String word1, String word2){
    if(word1.length() != word2.length()){
      return false;
    }
    int count = 0;
    for(int i = 0; i < word1.length(); i++){
      if(word1.charAt(i) == word2.charAt(i)){
        count++;
      }
    }
    if(count == word1.length()-1){
      return true;
    }
    return false;
  }
}