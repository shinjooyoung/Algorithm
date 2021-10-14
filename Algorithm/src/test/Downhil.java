package test;

import java.util.Scanner;

public class Downhil {
	
	static int m;
	static int n;
	static int[] x = {1,-1,0,0};
	static int[] y = {0,0,1,-1};
	
	static int[][] table;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();


		
		table = new int[m][n];
		dp = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				table[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		}
		
		dfs(0,0);
		

		
		System.out.println(dp[0][0]);

	}

	private static int dfs(int i, int j) {
		
		if(i == m-1 && j == n-1) return 1;
		if(dp[i][j] != -1) return dp[i][j];
		
		dp[i][j] = 0;
		
		for(int k = 0; k < 4; k++) {
			int nx = i + x[k];
			int ny = j + y[k];
			
			if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
				
				if(table[i][j] > table[nx][ny]) {
					dp[i][j] += dfs(nx,ny);
				}
			}
		}
		
		return dp[i][j];
	}

}
