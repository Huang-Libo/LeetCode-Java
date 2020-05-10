/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class LeetCode_121_best_time_to_buy_and_sell_stock {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        LeetCode_121_best_time_to_buy_and_sell_stock leetCode_121_best_time_to_buy_and_sell_stock
                = new LeetCode_121_best_time_to_buy_and_sell_stock();
        System.out.println(leetCode_121_best_time_to_buy_and_sell_stock.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price < minPrice) {
                minPrice = price;
            } else {

                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }
}
