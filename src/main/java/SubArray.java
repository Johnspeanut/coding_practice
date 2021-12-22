import java.util.ArrayList;
import java.util.List;

class SubArray {

  public static void main(String[] args) {
    SubArray subArray = new SubArray();
    subArray.getSubArray(new int[]{23,2,6,4,7});
  }
  public boolean checkSubarraySum(int[] nums, int k) {
    List<List<Integer>> list = getSubArray(nums);
    for(int i = 0; i < list.size(); i++){
      List<Integer> values = list.get(i);
      int sum = getSum(values);
      if(sum % k != 0){
        return true;
      }
    }
    return false;
  }

  private List<List<Integer>> getSubArray(int[] nums){
    List<List<Integer>> array = new ArrayList<>();
    for(int i = 0; i < nums.length; i++){
      for(int j = i; j < nums.length; j++){
        List<Integer> sub = new ArrayList<>();
        for(int k = i; k <= j; k++){
          sub.add(nums[k]);
        }
        array.add(sub);
      }
    }
    return array;

  }

  private int getSum(List<Integer> nums){
    int res = 0;
    for(int i = 0; i < nums.size(); i++){
      res += nums.get(i);
    }
    return res;
  }
}