package study;

import java.util.Scanner;

public class DisjointSet {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int num = sc.nextInt();
		
		int[] parent = new int[n+1];
		
		for(int i = 0; i <= n; i++) {
			parent[i] = i;
		}

		for(int i = 0; i < num; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(a, b, parent);
		}
		
		System.out.print("각 원소가 속한 집합: ");
	
		for(int i = 1; i <= n; i++) {
			System.out.print(findParent(i, parent) + " ");
		}
		System.out.println();
		System.out.print("부모 테이블: ");
		
		for(int i = 1; i <= n; i++) {
			System.out.print(parent[i] +" ");
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
