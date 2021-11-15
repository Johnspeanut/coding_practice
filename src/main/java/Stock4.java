class Stock4 {
  public int maxProfit(int k, int[] prices) {
    int m = prices.length;
    // int k = 2;
    int[][][] dp = new int[m][k+1][2];
    for(int i = 0; i < m; i++){
      for(int j = k; j >= 1;j--){
        if(i-1 == -1){
          dp[i][j][0] = 0;
          dp[i][j][1] = Integer.MIN_VALUE;

          continue;
        }
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
        dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
      }
    }
    return dp[m-1][k][0];
  }
}