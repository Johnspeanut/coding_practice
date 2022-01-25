public class Dudu {

  public double method23(float x, int n) {
    double value = 0;
    for (int i = 1; i <= n; i++) {
      value += Math.pow(x, i);
    }
    return value;
  }

  // n can be set to 10 in this case
  public int method24(int n) {
    int result = 0;
    for (int i = 1; i <= n; i++) {
      result += factorial(i);
    }
    return result;
  }

  private int factorial(int n) {
    int result = 1;
    for (int i = n; i >= 1; i--) {
      result *= i;
    }
    return result;
  }

}
