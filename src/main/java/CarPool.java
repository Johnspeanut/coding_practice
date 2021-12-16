
class CarPool{

  public static void main(String[] args) {
    CarPool carPool = new CarPool();
    carPool.carPooling(new int[][]{{2,1,5},{3,5,7}},3);
  }
  public boolean carPooling(int[][] trips, int capacity) {
    Difference difference = new Difference(1001);
    for(int[] trip:trips){
      difference.update(trip);
    }
    int[] results = difference.getResult();
    for(int i = 0; i < results.length; i++){
      if(results[i] > capacity){
        return false;
      }
    }
    return true;

  }

  class Difference{
    int n;
    int[] diff;
    int[] result;
    public Difference(int n){
      this.n = n;
      diff = new int[n];
      result = new int[n];
    }

    public void update(int[] trip){
      int value = trip[0];
      int fromCity = trip[1];
      int toCity = trip[2];
      diff[fromCity] += value;
      if(toCity+1 < n){
        diff[toCity+1] -= value;
      }

    }

    public int[] getResult(){
      result[0] = diff[0];
      for(int i = 1; i < n; i++){
        result[i] = diff[i] + result[i-1];
      }
      return this.result;
    }
  }
}