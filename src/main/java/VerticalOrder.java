import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

class VerticalOrder  {

  public static void main(String[] args) {
    VerticalOrder verticalOrder = new VerticalOrder();
//    verticalOrder.verticalTraversal();
  }
  TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map;
  public List<List<Integer>> verticalTraversal(TreeNode root) {
    map = new TreeMap<>();
    traverse(0,0,root);
    List<List<Integer>> result = new ArrayList<>();
    for(TreeMap<Integer,PriorityQueue<Integer>> elements:map.values()){
      result.add(new ArrayList<>());
      for(PriorityQueue<Integer> element:elements.values()){
        while(!element.isEmpty()){
          result.get(result.size()-1).add(element.poll());
        }
      }
    }
    return result;

  }

  private void traverse(int row, int col, TreeNode root){
    if(root == null) return;
    if(!map.containsKey(row)){
      map.put(col, new TreeMap<>());
    }
    if(!map.get(col).containsKey(row)){
      map.get(col).put(row, new PriorityQueue<>());
    }
    map.get(col).get(row).offer(root.val);
    traverse(row+1, col-1,root.left);
    traverse(row+1, col+1,root.right);
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

}