package study;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
	
	static int inf = 987654321;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		
		
		boolean [] visit = new boolean[n+1];
		
		int [] dist = new int[n+1];
		
		int [][]node = new int[n+1][n+1];
		
		Arrays.fill(dist, inf);
		
		
		
		for(int i = 0; i < m; i++) {
			node[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		
		dijkstra(n, start, node, dist, visit);
		
		
		for(int num : dist) {
			System.out.println(num);			
		}
		
		
		
	}

	private static void dijkstra(int n, int start, int[][] node, int[] dist, boolean[] visit) {
		
		node[start][start] = 0;
		dist[start] = 0;
		
		for(int i = 1; i <= n; i++ ) {
			int idx = 0;
			int min = inf;
			
			//시작점이 무조건 1이 아니기 때문에 최대 수보다 작은 idx를 찾음
			for(int j = 1; j <= n; j++) {
				if(!visit[j] && min > dist[j]) {
					idx = j;
					min = dist[j];
				}
			
			}
			visit[idx] = true;
			
			for(int j = 1; j <=n; j++) {
				if(node[idx][j] != 0 && dist[j] > dist[idx] + node[idx][j]) {
					dist[j] = dist[idx] + node[idx][j];
				}
			}
		}
		
	}

}
