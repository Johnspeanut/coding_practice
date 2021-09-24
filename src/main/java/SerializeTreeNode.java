import java.util.Arrays;
import java.util.LinkedList;
import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeTreeNode {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if(root == null){
      return "#";
    }
    String left = serialize(root.left);
    String right = serialize(root.right);
    return left + "," + right + "," + root.val + ",";
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] arr = data.split(",");
    LinkedList<String> list = new LinkedList<>(Arrays.asList(arr));
    return helper(list);
  }

  private TreeNode helper(LinkedList<String> list){
    if(list.getLast().equals("#")){
      list.removeLast();
      return null;
    }
    String temp = list.getLast();
    if(temp.equals("")){
      list.removeLast();
    }
    TreeNode root = new TreeNode(Integer.valueOf(list.getLast()));
    list.removeLast();
    root.right = helper(list);
    root.left = helper(list);
    return root;
  }
   public class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode(int x) { val = x; }
 }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));