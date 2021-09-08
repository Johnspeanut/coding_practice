import java.util.HashMap;
import java.util.Stack;

public class BalanceBrackets {

  public static void main(String[] args) {

  }

  boolean isBalanced(String s){
    HashMap<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');
    // Write your code here
    Stack<Character> stack = new Stack<>();
    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      if(map.containsKey(c)){
        char top = stack.empty()? '#':stack.pop();
        if(top != map.get(c)){
          return false;
        }
      }else{
        stack.push(s.charAt(i));
      }




    }
    return stack.empty();
  }

}
