package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Node{
	int x;
	int y;
	
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	int getY(){
		return this.y;
	}
	
	int getX() {
		return this.x;
	}
}

public class ExitMiro {

	static int n,m;
	static int[][] miro;
	static int[]dx = {0,0,1,-1};
	static int[]dy = {-1,1,0,0};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();  
		
		miro = new int[n][m];
		for(int i = 0; i < n; i++) {
			String nums = sc.next();
			sc.nextLine();
			for(int j = 0; j < m; j++) {
				int num = nums.charAt(j) - '0';
				miro[i][j] = num;
			}
		}
		
		startMiro(0,0);
	}
	private static void startMiro(int x, int y) {
		Queue<Node> que = new LinkedList<Node>();
		que.offer(new Node(x,y));
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			for(int i = 0; i < 4; i++) {
			
				int nodeX = node.getX();
				int nodeY = node.getY();
				
				int nodeDx = nodeX + dx[i];
				int nodeDy = nodeY + dy[i];
				
				if(nodeDx >=0 && nodeDy >=0 && nodeDx < n && nodeDy < m) {
					
					if (miro[nodeDx][nodeDy] == 0) {
						continue;
					}
					if(miro[nodeDx][nodeDy] == 1) {
						miro[nodeDx][nodeDy] = miro[nodeX][nodeY] + 1;
						que.offer(new Node(nodeDx,nodeDy));
					}
				}
			}
			
			
		}
		
		System.out.println(miro[n-1][m-1]);
			
	}

}
