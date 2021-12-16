import java.util.LinkedList;
import java.util.List;
class SpiralMatrix {

  public static void main(String[] args) {
    SpiralMatrix spiralMatrix = new SpiralMatrix();
    spiralMatrix.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
  }
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new LinkedList<>();
    int upperBound = 0;
    int lowerBound = matrix.length-1;
    int leftBound = 0;
    int rightBound = matrix[0].length -1;
    while(upperBound <= lowerBound && leftBound <= rightBound){
      if(upperBound <= lowerBound){
        for(int i = leftBound; i <= rightBound; i++){
          result.add(matrix[upperBound][i]);
        }
        upperBound++;
      }
      if(leftBound <= rightBound){
        for(int i = upperBound; i <= lowerBound; i++){
          result.add(matrix[i][rightBound]);
        }
        rightBound--;
      }
      if(upperBound <= lowerBound){
        for(int i = rightBound; i >= leftBound; i--){
          result.add(matrix[lowerBound][i]);
        }
        lowerBound--;
      }
      if(leftBound <= rightBound){
        for(int i = lowerBound; i >= upperBound; i--){
          result.add(matrix[i][leftBound]);
        }
        leftBound++;
      }
    }
    return result;

  }
}