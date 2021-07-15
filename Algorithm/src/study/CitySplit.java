package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Load implements Comparable<Load>{
	int a;
	int b;
	int cost;
	
	Load(int a, int b, int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}

	/**
	 * @return the a
	 */
	public int getA() {
		return a;
	}

	/**
	 * @param a the a to set
	 */
	public void setA(int a) {
		this.a = a;
	}

	/**
	 * @return the b
	 */
	public int getB() {
		return b;
	}

	/**
	 * @param b the b to set
	 */
	public void setB(int b) {
		this.b = b;
	}

	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public int compareTo(Load others) {
		if(this.cost < others.cost) {
			return -1;
		}
		return 1;
	}
	
	
}

public class CitySplit {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<Load> connections  = new ArrayList<Load>();
		
		int[] parent = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			connections.add(new Load(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		Collections.sort(connections);
		
		Queue<Load> q = new LinkedList<Load>();
		
		q.add(connections.get(0));
		int sum =0;
		int last = 0;
		for(int i = 0; i < m; i++) {
			Load lode = connections.get(i); 
			
			int nowA = lode.getA();
			int nowB = lode.getB();
			int cost = lode.getCost();
			
			int parentA = findParent(parent, nowA);
			int parentB = findParent(parent, nowB);
			if(parentA == parentB) {
				continue;
			} else {
				sum += cost;
				last = cost;
				union(parent, nowA, nowB);
				
			}
		}
		System.out.println(sum - last);
	}

	private static void union(int[] parent, int x, int y) {
		int a = parent[x];
		int b = parent[y];
		if(a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

	private static int findParent(int[] parent, int x) {
		if(parent[x] == x) {
			return x;
		} else {
			parent[x] = findParent(parent, parent[x]);
			return parent[x]; 
		}
	}
	


}
