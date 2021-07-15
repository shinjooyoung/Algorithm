package study;

import java.util.Scanner;

public class FloydWarshall {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int inf = 987654321;
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] nums = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j) {
					nums[i][j] = 0;
				} else {
					nums[i][j] = inf;					
				}
			}
		}
		
		for(int i = 1; i <= m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			nums[a][b] = c;
		}
		
		for(int k = 1; k <= n; k++ ) {
			for(int i = 1; i <= n; i++ ) {
				for(int j = 1; j <= n; j++ ) {
					nums[i][j] = Math.min(nums[i][j], nums[i][k] + nums[k][j]);
				}
			}	
		}
		
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
		

	}
}
