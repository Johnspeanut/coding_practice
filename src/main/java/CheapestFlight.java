public class CheapestFlight {

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    //dp[i][j] means the minimum distance to reach from src to i with matmost j edges.
    // Atmost k stops, means k+1 edges
    int[][] dp = new int[n][k + 2];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k + 2; j++) {
        dp[i][j] = i == src ? 0 : Integer.MAX_VALUE;
      }
    }

    for (int i = 1; i <= k + 1; i++) {
      for (int[] flight : flights) {
        int from = flight[0];
        int to = flight[1];
        int price = flight[2];
        if (dp[from][i - 1] != Integer.MAX_VALUE) {
          dp[to][i] = Math.min(dp[to][i], dp[from][i - 1] + price);
        }

      }
    }
    return dp[dst][k + 1] == Integer.MAX_VALUE ? -1 : dp[dst][k + 1];
  }
}
