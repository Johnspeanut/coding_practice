import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class combination {

  public static void main(String[] args) {
    combination com = new combination();
    int[] nums = {1, 2,3};
    List<List<Integer>>  res = com.subsets(nums);

  }
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> comb = new LinkedList<>();
    backtrack(res, comb, 0, nums);
    return res;
  }

  void backtrack(List<List<Integer>> res, LinkedList<Integer> comb, int start, int[] nums){
    res.add(new ArrayList<Integer>(comb));
    for(int i = start; i < nums.length; i++){
      if(comb.contains(nums[i])){
        continue;
      }
      comb.add(nums[i]);
      backtrack(res, comb, i, nums);
      comb.removeLast();
    }

  }
}