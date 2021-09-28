package test;

import java.util.Scanner;

public class GoldMine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] location = new int[n][m];
			
			for(int j = 0; j < n; j++ ) {
				for(int k = 0; k < m; k++) {
					location[j][k] = sc.nextInt();
				}
			}
			int[][] dp = location.clone();
			
			for(int j = 1; j < m; j++ ) {
				for(int k = 0; k < n; k++) {
					
					int first = 0;
					int third = 0;
					
					if(k-1 > 0) {
						first = dp[k-1][j-1];
					}
					
					int second  = dp[k][j-1];
					
					if(k+1 < n) {
						third = dp[k+1][j-1];
					}
					
					dp[k][j]=dp[k][j] + Math.max(first, Math.max(second, third));
				}
			}
			int result = 0;
			for(int k = 0; k < n; k++) {
				result = Math.max(result, dp[k][m-1]);
			}
			
			System.out.println(result);
			
			
		}
		
		
		
	}

}