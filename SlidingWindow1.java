// BEST TIME TO BUY AND SELL STOCK
class SlidingWindow1 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lowestBuyPrice = prices[0];
        for (int ii = 1; ii < prices.length; ii++) {
            if (prices[ii] < lowestBuyPrice) {
                lowestBuyPrice = prices[ii];
            } else {
                int tempProfit = prices[ii] - lowestBuyPrice;
                maxProfit = Math.max(tempProfit, maxProfit);
            }
        }
        return maxProfit;
    }
}
