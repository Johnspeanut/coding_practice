import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    return threeSum(nums, 0);
  }

  public List<List<Integer>> threeSum(int[] nums, int target){
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    int n = nums.length;
    for(int i = 0; i < n; i++){
      List<List<Integer>> tuples = twoSum(nums, i + 1, target - nums[i]);
      for(List<Integer> tuple:tuples){
        tuple.add(nums[i]);
        res.add(tuple);
      }
      while(i < n -1 && nums[i] == nums[i+1]){
        i++;
      }

    }
    return res;
  }

  private List<List<Integer>> twoSum(int[] nums, int start, int target){
    // Arrays.sort(nums);
    int lo = start;
    int hi = nums.length-1;
    List<List<Integer>> res = new ArrayList<>();
    while(lo < hi){
      int left = nums[lo];
      int right = nums[hi];
      int sum = left + right;
      if(sum > target){
        hi --;
      }else if(sum < target){
        lo ++;
      }else{
        res.add(new ArrayList<>(Arrays.asList(left, right)));
        while(lo < hi && nums[lo] == left){
          lo ++;
        }
        while(lo < hi && nums[hi] == right){
          hi --;
        }
      }
    }
    return res;
  }
}