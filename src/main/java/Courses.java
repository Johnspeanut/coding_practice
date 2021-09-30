import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Courses {
  boolean hasCycle = false;
  List<Integer>[] graph;
  List<Integer> res;
  boolean[] visited;
  String[] color;

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    graph = buildGraph(numCourses, prerequisites);
    color = new String[numCourses];
    for(int i = 0; i < numCourses; i++){
      color[i] = "WHITE";
    }
    if(isCycle(numCourses, prerequisites)){
      System.out.println("is Cycle :" + hasCycle);
      return new int[0];
    }

    // List<Integer>[] graph = buildGraph(numCourses, prerequisites);
    res = new ArrayList<>();
    visited = new boolean[numCourses];
    for(int i = 0; i < numCourses; i++){
      if(visited[i] == false){
        traverse(graph, i);
      }
    }

    Collections.reverse(res);
    int[] finalResult = new int[numCourses];
    for(int i = 0; i < numCourses; i++){
      finalResult[i] = res.get(i);
    }
    // res.toArray(finalResult);
    return finalResult;
  }

  private void traverse(List<Integer>[] graph, int i){
    if(visited[i]){
      return;
    }
    visited[i] = true;
    for( int element:graph[i]){
      traverse(graph, element);
    }
    res.add(i);
  }

  private boolean isCycle(int numCourses, int[][] prerequisites){
    // List<Integer>[] graph = buildGraph(numCourses, prerequisites);

    for(int i = 0; i < numCourses; i++){
      if(color[i] == "WHITE"){
        System.out.println("color i :" + color[i]);
        dfs(graph, i);
      }

    }
    return hasCycle;
  }

  private void dfs(List<Integer>[] graph, int i){
    if(this.hasCycle){
      return;
    }
    color[i] = "GREY";
    System.out.println("color i :" + color[i]);
    for(int element:graph[i]){
      if(color[element] == "GREY"){
        hasCycle = true;
        // return;
      }else if(color[element] == "WHITE"){
        dfs(graph, element);
      }
    }
    color[i] = "BLACK";
  }

  private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
    List<Integer>[] graph = new LinkedList[numCourses];
    for(int i = 0; i < numCourses; i++){
      graph[i] = new LinkedList<>();
    }
    for(int[] edge: prerequisites){
      int from = edge[1];
      int to = edge[0];
      graph[from].add(to);
    }
    return graph;
  }

}
