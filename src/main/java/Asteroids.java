import java.util.Stack;

class Asteroids {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for(int i = 0; i < asteroids.length; i++){
      if(stack.isEmpty() || asteroids[i] > 0){
        stack.push(asteroids[i]);
      }else{
        while(true){
          int peek = stack.peek();
          if(peek < 0){
            stack.push(asteroids[i]);
            break;
          }else if(peek == -asteroids[i]){
            stack.pop();
            break;
          }else if(peek > -asteroids[i]){
            break;
          }else{
            stack.pop();
            if(stack.isEmpty()){
              stack.push(asteroids[i]);
              break;
            }
          }
        }
      }
    }

    int[] outcome = new int[stack.size()];
    for(int i = stack.size()-1; i >=0; i--){
      outcome[i] = stack.pop();
    }
    return outcome;
  }
}
