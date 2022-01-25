import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class WordLadder1 {

  public static void main(String[] args) {
    WordLadder1 wordLadder1 = new WordLadder1();
    List<String> list = new LinkedList<>();
    list.add("hot");
    list.add("dot");
    list.add("dog");
    list.add("lot");
    list.add("log");
    list.add("cog");
    wordLadder1.ladderLength("hit","cog",list);
  }


  Map<String, List<String>> adjList = new HashMap<>();
  boolean isFind;
  int result;
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordListSet = new HashSet<>(wordList);
    bfs(endWord, wordListSet);
    backtrack(beginWord, endWord, 0);
    return result;

  }

  private void backtrack(String beginWord, String endWord, int count){
    if(beginWord.equals(endWord)){
      isFind = true;
      result = count;
      return;
    }
    if(isFind){
      return;
    }
    if(!adjList.containsKey(beginWord)){
      return;
    }
    List<String> neighbors = adjList.get(beginWord);
    for(String neighbor:neighbors){
      backtrack(neighbor, endWord, count+1);
    }
  }

  private void bfs(String startWord, Set<String> wordListSet){
    Queue<String> q = new LinkedList<>();
    q.add(startWord);
    if(wordListSet.contains(startWord)){
      wordListSet.remove(startWord);
    }
    Set<String> isEnqueuedSet = new HashSet<>();
    isEnqueuedSet.add(startWord);
    while(!q.isEmpty()){
      int size = q.size();
      List<String> visited = new ArrayList<>();
      for(int i = 0; i < size; i++){
        String curr = q.poll();


        List<String> neighbors = findNeighbors(startWord, wordListSet);
        for(String neighbor:neighbors){
          visited.add(neighbor);
          if(!adjList.containsKey(curr)){
            adjList.put(curr, new LinkedList<String>());
          }
          adjList.get(curr).add(neighbor);
          if(!isEnqueuedSet.contains(neighbor)){
            q.add(neighbor);
            isEnqueuedSet.add(neighbor);
          }




        }
      }
//      for(int i = 0; i < visited.size(); i++){
//        if(wordListSet.contains(visited.get(i))){
//          wordListSet.remove(visited.get(i));
//        }
//      }

    }

  }

  private List<String> findNeighbors(String startWord, Set<String> wordListSet){
    List<String> neighbors = new ArrayList<>();
    char[] startWordArray = startWord.toCharArray();
    for(int i = 0; i < startWord.length(); i++){
      char oldChar = startWordArray[i];
      for(char c = 'a'; c <= 'z'; c++){
        startWordArray[i] = c;
        if(c == oldChar || !wordListSet.contains(String.valueOf(startWordArray))) continue;
        neighbors.add(String.valueOf(startWordArray));

//        if(wordListSet.contains(String.valueOf(startWordArray))){
//          neighbors.add(String.valueOf(startWordArray));
//        }
      }
      startWordArray[i] = oldChar;
    }
    return neighbors;
  }



}