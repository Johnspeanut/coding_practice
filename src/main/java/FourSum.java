import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FourSum {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return nSum(nums, 4, 0, target);
  }

  public List<List<Integer>> nSum(int[] nums, int n, int start, int target){
    int sz = nums.length;
    List<List<Integer>> res = new ArrayList<>();
    if( n < 2||sz < n){
      return res;
    }
    if(n == 2){
      int lo =  start;
      int hi = sz - 1;
      while(lo < hi){
        int left = nums[lo];
        int right = nums[hi];
        int value = left + right;
        if(value < target){
          lo ++;
        }else if(value > target){
          hi --;
        }else{
          res.add(new ArrayList<>(Arrays.asList(left, right)));
          while(lo < hi && left == nums[lo]){
            lo ++;
          }
          while(lo < hi && right == nums[hi]){
            hi --;
          }
        }
      }
    }else{
      for(int i = 0; i < sz; i++){
        List<List<Integer>> sub = nSum(nums, n - 1, i + 1, target - nums[i]);
        for(List<Integer> arr: sub){
          arr.add(nums[i]);
          res.add(arr);
        }
        while(i < sz - 1 && nums[i] == nums[i+1]){
          i++;
        }
      }
    }
    return res;
  }



}