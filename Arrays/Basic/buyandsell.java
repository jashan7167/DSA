//keep the track of the minimal on the left and then subtract it from the element at the ith position

public class buyandsell {
  public static int maxProfit(int[] prices) {
    // get the lowest price day first
    int min = prices[0];
    int profit = 0;

    for(int i = 1 ; i < prices.length ; i++)
    {
      int cost = prices[i]-min;
      profit = Math.max(cost,profit);
      min = Math.min(prices[i],min);  
    }
    
    return profit;
  }

  public static void main(String[] args) {

    System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
  }
}
