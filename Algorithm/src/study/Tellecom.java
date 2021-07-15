package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node3 implements Comparable<Node3>{
	int node;
	int cost;
	
	Node3(int node, int cost) {
		this.node = node;
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
	public int compareTo(Node3 others) {
		if(others.cost > this.cost) {
			return -1;
		}
		
		return 1;
	}
	
}

public class Tellecom {
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//도시 갯수
		int n = sc.nextInt();
		//통로 갯수
		int m = sc.nextInt();
		//메세지를 보내는 도시
		int c = sc.nextInt();
	
		int inf = 987654321;
		
		ArrayList<ArrayList<Node3>> nodes = new ArrayList<ArrayList<Node3>>();
		boolean[] visit = new boolean[n+1];
		
		int[] dist = new int[n+1];
		
		Arrays.fill(dist, inf);
		
		
		for(int i = 0; i <= n; i++) {
			nodes.add(new ArrayList<Node3>());
		}
		
		for(int i = 0; i <m; i++ ) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			nodes.get(x).add(new Node3(y,z));
		}
	
		dijkstra(c, nodes, visit, dist);
		
		int cityNum = 0;
		int cost = 0;
		
		for(int i = 1; i < dist.length; i++) {
			if(i == c) {
				continue;
			}
			if(inf > dist[i]) {
				cityNum++;
				cost = Math.max(dist[i], cost);
			}
		}
		
		System.out.println(cityNum + " " + cost);
		
		
	}

	private static void dijkstra(int c, ArrayList<ArrayList<Node3>> nodes, boolean[] visit, int[] dist) {
		
		dist[c] = 0;
		
		PriorityQueue<Node3> que = new PriorityQueue<Node3>();
		
		que.offer(new Node3(c,0));
		
		while(!que.isEmpty()) {
			Node3 selectNode = que.poll();
			int selectNodeNum = selectNode.getNode();
			int selectNodeCost = selectNode.getCost();
			if(visit[selectNodeNum]) {
				continue;
			}
			visit[selectNodeNum] = true;
			
			ArrayList<Node3> selectNodes = nodes.get(selectNodeNum);
			
			for(int i = 0; i < selectNodes.size(); i++) {
				Node3 node = selectNodes.get(i);
				int nodeNum = node.getNode();
				int cost = node.getCost();
				
				if(dist[nodeNum] > selectNodeCost + cost) {
					dist[nodeNum] = selectNodeCost + cost;
					que.offer(node);
				}
			}
		}
		
	}

}
