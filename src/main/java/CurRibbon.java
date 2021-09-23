public class CurRibbon {

  public static void main(String[] args) {
//    CurRibbon curRibbon = new CurRibbon();
//    int res = curRibbon.maxLength(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100000,1,1,1,1,1,1,1,1,1,1},100049);
    CurRibbon curRibbon = new CurRibbon();
    int res = curRibbon.maxLength(new int[]{5,7,9},22);
//    int res = curRibbon.maxLength(new int[]{5,7,9},3);
//    int res = curRibbon.maxLength(new int[]{100000,1,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000},50);

    System.out.println("the res value is " + res);
  }


  public int maxLength(int[] ribbons, int k) {
    int left = 1;
    int right = 0;
    int sum = 0;
    for(int ele:ribbons){
      right = Math.max(right, ele);
      sum += ele;
    }
//     if(k > sum){
//         return 0;
//     }
     System.out.println("the right is " + right);
//    int value = right;
    right ++;

    while(left < right){
      int mid = left + (right - left)/2;
      if(numRibbons(ribbons,mid) == k){
        left = mid + 1;
      }
      if(numRibbons(ribbons, mid) < k){
        right = mid;
      }else if(numRibbons(ribbons, mid) > k){
        left = mid + 1;
      }
      // System.out.println("the mid is " + mid);
      // System.out.println("the left is " + left);
      // System.out.println("the right is " + right);
    }
    if(left-1 == 0){
      return 0;
    }
//int value = numRibbons(ribbons, left-1);
//    System.out.println("the left-1 is " + (left - 1));
//    System.out.println("the value is " + value);
    return numRibbons(ribbons, left-1) >= k? (left -1):0;
  }

  private int numRibbons(int[] ribbons, int len){
    int res = 0;
    for(int i = 0; i < ribbons.length;i++){
      int cap = ribbons[i];
      res += ribbons[i]/len;
//      while(cap > 0){
//        if(cap < len){
//          break;
//        }else{
//          cap -= len;
//          res ++;
//        }
//      }
    }
    return res;
  }
}
