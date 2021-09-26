import java.util.Comparator;
import java.util.PriorityQueue;

public class Maximum_units_truck {

  public static void main(String[] args) {
    Maximum_units_truck maximum_units_truck = new Maximum_units_truck();
//    int[][] box = {{1,3},{2,2},{3,1}};
    int[][] box = {{1,3},{5,5},{2,5},{4,2},{4,1},{3,1},{2,2},{1,3},{2,5},{3,2}
    };
    int value = maximum_units_truck.maximumUnits(box, 35);

    System.out.println("The value is " + value);
  }
  public int maximumUnits(int[][] boxTypes, int truckSize) {
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(boxTypes.length, new Comparator<int[]>(){
      public int compare(int[] o1, int[] o2){
        return o2[1] - o1[1];
      }
    });

    for(int[] element:boxTypes){
      pq.offer(element);
    }

    int total = 0;
    while(truckSize > 0 && !pq.isEmpty()){
      int[] cur = pq.poll();


      if(truckSize >= cur[0]){
        truckSize -= cur[0];
        total += cur[1] * cur[0];
      }else{
        total += truckSize* cur[1];
        truckSize = 0;
      }
    }
    return total;
  }
}
