class Solution {
  public int numWaterBottles(int numBottles, int numExchange) {
    int sum = numBottles;
    while (numBottles >= numExchange) {
      sum += numBottles / numExchange;
      // remaining bottles are added to the bottles to exchanges further
      numBottles = (numBottles / numExchange) + (numBottles % numExchange);
    }
    return sum;
  }
}