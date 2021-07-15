package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Node4 implements Comparable<Node4>{
	int x;
	int y;
	int cost;
	
	Node4(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
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
	public int compareTo(Node4 others) {
		if(this.cost < others.cost) {
			return -1;
		}
		return 1;
	}
	
	
	
}

public class Cruscal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<Node4> nodeArr = new ArrayList<Node4>();
		
		int[] parent = new int[n+1];
		
		for(int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		for(int i = 0; i < m; i++) {
			nodeArr.add(new Node4(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		Collections.sort(nodeArr);
		
		int sum = 0;
		for(int i = 0; i < m; i++) {
			Node4 node = nodeArr.get(i);
			
			int a = node.getX();
			int b = node.getY();
			
			if(findParent(parent, a) == findParent(parent, b)) {
				continue;
			} else {
				sum += node.cost;
				union(parent, a, b);
			}


		}
		
		System.out.println(sum);
	}

	private static int findParent(int[] parent, int x) {
		if(parent[x] == x) {
			return x;
		} else {
			parent[x] = findParent(parent, parent[x]);
			return parent[x];
		}
	}
	
	
	private static void union(int[] parent, int x, int y) {
		int a = parent[x];
		int b = parent[y];
		if(a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}
	

}


