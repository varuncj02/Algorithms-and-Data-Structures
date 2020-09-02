/**
 * 
 * @author Varun Joshi
 * Dynamic Programming Problem
 *
 */
public class RodCutting {

	public static int maxProfit(int[] prices, int n) {
		
		int[] total = new int[n+1];
		total[0] = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				total[i] = Integer.max(total[i], prices[j - 1] + total[i - j]);
			}
		}
		
		return total[n];
	}
	
	public static void main(String[] args) {
		int[] prices = {5, 5, 8, 9, 10, 17, 17, 20};
		int n = 4;
		System.out.println("Profit is " + maxProfit(prices, n));
	}
}
