package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


class Node2 implements Comparable<Node2>{
	int cost;
	int node;
	
	Node2(int cost, int node){
		this.cost = cost;
		this.node = node;
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


	/**
	 * @return the node
	 */
	public int getNode() {
		return node;
	}


	/**
	 * @param node the node to set
	 */
	public void setNode(int node) {
		this.node = node;
	}



	@Override
	public int compareTo(Node2 others) {
		if(this.cost < others.cost) {
			return -1;
		}
		return 1;
	}
}

public class Dijkstra2 {
	
	static int inf = 987654321;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		
		
		boolean [] visit = new boolean[n+1];
		
		int [] dist = new int[n+1];
		
		Arrays.fill(dist, inf);
		
		ArrayList<ArrayList<Node2>> nodes = new ArrayList<ArrayList<Node2>>();
		
		for(int i = 0; i <= n; i++) {
			nodes.add(new ArrayList<Node2>());
		}
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			nodes.get(a).add(new Node2(c,b));
		}
		
		
		dijkstra(n, start, nodes, dist, visit);
		
		
		for(int i = 1; i <= n; i++) {
			System.out.println(dist[i]);			
		}
		
		
		
	}

	private static void dijkstra(int n, int start, ArrayList<ArrayList<Node2>> nodes, int[] dist, boolean[] visit) {
		PriorityQueue eq = new PriorityQueue<Node2>();
		eq.offer(new Node2(0, start));
		dist[start] = 0;
		while(!eq.isEmpty()) {
			Node2 pollNode = (Node2) eq.poll();
			
			int nodeNum = pollNode.getNode();
			int cost = pollNode.getCost();
			
			if(visit[nodeNum]) {
				continue;
			}
			visit[nodeNum] = true;
			ArrayList<Node2> nodeArr = nodes.get(nodeNum);
			
			for(int i = 0; i < nodeArr.size(); i++) {
				Node2 node = nodeArr.get(i);
				int nodeCost = dist[node.getNode()];
				if(nodeCost > cost + node.getCost()) {
					dist[node.getNode()] = cost + node.getCost();
				}
				eq.offer(node);	
			}
		}
	}
}
