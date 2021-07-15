package study;

import java.util.Scanner;

public class DisjointSet2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int num = sc.nextInt();
		
		int[] parent = new int[n+1];
		
		for(int i = 0; i <= n; i++) {
			parent[i] = i;
		}

		boolean sycle = false;
		for(int i = 0; i < num; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(findParent(a, parent) == findParent(b, parent)) {
				sycle = true;
				break;
			} else {
				union(a, b, parent);				
			}
		}
		
		if(sycle) {
			System.out.println("사이클이 있음");
		} else {
			System.out.println("사이클이 없");
		}
		
	
	}

	private static void union(int a, int b, int[] parent) {
		
		a = findParent(a, parent);
		b = findParent(b, parent);
		if(a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	private static int findParent(int x, int[] parent) {
		if(x == parent[x]) {
			return x;
		} else {
			parent[x] = findParent(parent[x], parent);
			return parent[x];
		}
	}

}
