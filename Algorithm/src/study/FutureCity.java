package study;

import java.util.Scanner;

public class FutureCity {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		//전체 회사 갯수
		int n = sc.nextInt();
		//경로 갯수
		int m = sc.nextInt();
		
		long beforeTime = System.currentTimeMillis();
		
		int[][] company = new int[n+1][n+1];
		
		int inf = 987654321;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j) {
					company[i][j] = 0;
				}
				company[i][j] = inf;
			}
		}
		
		for(int i = 1; i <= m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			company[a][b] = 1;
			company[b][a] = 1;
		}
		
		int x = sc.nextInt();
		int k = sc.nextInt();
		
		
		for(int y = 1; y <= n; y++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					company[i][j] = Math.min(company[i][j], company[i][y]+company[y][j]);
				}
			}
		}
		
		if(company[1][k] + company[k][x] >= inf) {
			System.out.println(-1);
		} else {
			System.out.println(company[1][k] + company[k][x]);
		}
		
		
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime)/1000;
		
		System.out.println("시작(s) : " + beforeTime);
		System.out.println("종료(s) : " + afterTime);
		System.out.println("시간차이(s) : " + secDiffTime);
		

	}

}
