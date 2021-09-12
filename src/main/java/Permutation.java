import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutation {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    ArrayList<Integer> nums_lst = new ArrayList<Integer>();
    for(int num:nums){
      nums_lst.add(num);
    }
    backtrack(res, nums,nums_lst, 0);
    return res;
  }

  void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> nums_lst, int start){
    if(start == nums.length){
      res.add(new ArrayList<Integer>(nums_lst));
      return;
    }
    for(int i = start; i < nums.length; i++){
      // if(nums_lst.contains(nums[i])){
      //     continue;
      // }
      // nums_lst.add(nums[i]);
      Collections.swap(nums_lst, start, i);
      backtrack(res, nums, nums_lst, start+1);
      // nums_lst.removeLast();
      Collections.swap(nums_lst, start, i);
    }
  }
}

