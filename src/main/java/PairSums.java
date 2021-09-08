import java.util.HashMap;

public class PairSums {

    // Add any helper functions you may need here


    int numberOfWays(int[] arr, int k) {
      // Write your code here
      HashMap<Integer,Integer> map = new HashMap<>();
      for(int i = 0; i < arr.length; i++){
        map.put(arr[i], map.getOrDefault(map.get(arr[i]), 0) + 1);
      }
      int count = 0;
      for(int i = 0; i < arr.length; i++){
        int value = k - arr[i];
        if(map.containsKey(value) && map.get(value) == arr[i]){
          count += factorial(map.get(value))/factorial(map.get(value) - 2);
          map.put(arr[i], 0);
        }
        if(map.containsKey(value) && map.get(value) > 0){
          count ++;
          map.put(arr[i], map.get(arr[i]) - 1);
          map.put(value, map.get(value) - 1);
        }
      }
      return count;
    }


    int factorial(int number) {
      int fact = 1;
      while (number >= 1) {
        fact *= number;
        number--;
      }
      return fact;
    }


  }
