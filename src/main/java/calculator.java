import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

class calculator  {
  public int calculate(String s) {
    return simpleCal(s, new AtomicInteger(0));


  }

  public static void main(String[] args) {
    calculator calculator1 = new calculator();
    calculator1.calculate("(17-(((((((((13*2)-(9+9))+2)/(((14+9)-(6*13))+((7*17)*(19*20))))+((((19*2)+(20+2))+((16-20)-(7/3)))*(((1-11)+(13+2))*((20-14)*(9*7)))))*(14/((((16+2)*(15*3))-(5/(15*3)))/(((3*9)+(19+17))-((19+11)+(11+14))))))-((((((8/18)-(4-12))+((20*10)+(3-8)))+3)-((((12-2)*(8+20))+((15-7)/(6+11)))-(((3*4)/(16+7))+(10+(9+10)))))+(((((14*15)+(18+19))/((16-6)+(7/8)))*(((12*16)-(18/10))/(6+(14-9))))-((((10/10)/2)+((14+6)+(17*7)))+14))))+(13+((((((8*10)*(3+8))+(18-(3*19)))+(((1+20)+(13/8))+9))*(17+6))/(((((14-1)+(9+1))+(6*(10*19)))+(((20/8)+(7+20))*((6*3)*(10*18))))*((((20+1)-(6-12))+((10+18)*(18*11)))-(((11+12)+(9-14))*(16*(5-8))))))))+(1/(((((((1+5)+(8/18))-(7+(19*20)))+(((19-20)-(17/19))*((11-15)*(12+13))))+((((20*16)+(7*8))*16)+(((19+6)+(17+15))*((18/8)+7))))+(((((3+2)/(19-17))-((16/11)*(13+19)))+(((19-20)-(20-9))-((15+18)*(14+3))))+(((1+11)-((3+1)/(15+4)))-(((19*19)/(18-2))*((9-8)+(16+19))))))+13))))");
  }
  public int simpleCal(String s, AtomicInteger start){
    Stack<Integer> stack = new Stack<>();
    int num = 0;
    char sign = '+';
    for(; start.get() < s.length(); start.incrementAndGet()){
      char c = s.charAt(start.get());
      if(c >= '0' && c <= '9'){
        num = num*10 + (c-'0');
      }
      if(c == '('){
        start.incrementAndGet();
        num = simpleCal(s, start);
        if(start.get() < s.length()){
          c = s.charAt(start.get());
        }
      }
      if(c == ')'){
        start.incrementAndGet();
        break;
      }
      if(((c < '0' || c > '9' ) && c != ' ')|| start.get() == s.length()-1){
        int pre;
        switch(sign){
          case '+':
            stack.push(num);
            break;
          case '-':
            stack.push(-num);
            break;
          case '*':
            pre = stack.pop();
            stack.push(num * pre);
            break;
          case '/':
            pre = stack.pop();
            stack.push(pre/num);
            break;

        }
        sign = c;
        num = 0;
      }
    }

    if(num != 0||sign!= '+' && sign != '-'){
      switch(sign){
        case '+':
          stack.push(num);
          break;
        case '-':
          stack.push(-num);
          break;
        case '*':
          stack.push(stack.pop() * num);
          break;
        case '/':
          stack.push(stack.pop()/num);
          break;
      }
    }

    int res = 0;
    while(!stack.isEmpty()){
      res += stack.pop();
    }
    return res;
  }

}