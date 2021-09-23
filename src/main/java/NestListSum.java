public class NestListSum {

  public static void main(String[] args) {
    Element[] list = new Element[2];
    list[0] = new Element(true,1, null);
    Element[] listsub= new Element[2];
    listsub[0] = new Element(true, 2,null);
    listsub[1] = new Element(true, 3,null);

    list[1] = new Element(false,-1,listsub);
    NestListSum nestListSum = new NestListSum();
    int value = nestListSum.nestSum(list);
    System.out.println("the value is " + value);

  }
  int sum = 0;
  public int nestSum(Element[] list){

    int len = list.length;
    for(int i = 0; i < len; i++){
      helper(list[i], 1);
    }
    return sum;
  }

  public void helper(Element list, int depth){
    if(list.intOrList){
      sum += depth*list.getValue;
      return;
    }
    depth ++;
    Element[] subList = list.elementList;
    for(int i = 0; i < subList.length; i++){
      helper(subList[i], depth);
    }
  }

  static class Element{
    boolean intOrList;
    int getValue;
    Element[] elementList;

    public Element(boolean intOrList, int getValue, Element[] elementList){
      this.intOrList = intOrList;
      this.getValue = getValue;
      this.elementList = elementList;
    }
  }

}
