package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class SnakeBody implements Comparable<SnakeBody>{
	int x;
	int y;
	int time;
	
	SnakeBody(int x, int y, int time){
		this.x = x;
		this.y = y;
		this.time = time;
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
	 * @return the num
	 */
	public int getTime() {
		return time;
	}

	/**
	 * @param num the num to set
	 */
	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public int compareTo(SnakeBody others) {
		if(this.time < others.time) return -1; 
		return 1;
	}
	
	
}

public class Snake2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] filed = new int[n][n];
		int[][] snake = new int[n][n];
		
		List<SnakeBody> snakes = new LinkedList<SnakeBody>();
		
		
		for(int i = 0; i < k; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			filed[a-1][b-1] = 1;
		}
		
		int l = sc.nextInt();
		
		// 방향 오른쪽 방향 0 부터 오른쪽으로 +1...
		int[] xn = {0,1,0,-1};
		int[] yn = {1,0,-1,0};
		
		int x = 0;
		int y = 0;
		
		snake[x][y] = 1;
		snakes.add(new SnakeBody(x,y,0));
		int time = 0;
		int location = 0;
		
		
		String[] direct = new String[1000];
		Arrays.fill(direct, "X");

		for(int i = 0; i < l; i++) {
			int a = sc.nextInt();
			String b = sc.next();
			direct[a] = b;
		}
		while(true) {
			
			time++;
			int nowX  = x + xn[location];
			int nowY = y + yn[location];
			if(nowX >= n || nowY >=n || nowX < 0 || nowY < 0 || snake[nowX][nowY] == 1) {
				break;
			}
			// 머리부터 
			snake[nowX][nowY] = 1;
			snakes.add(new SnakeBody(nowX,nowY,time));
			
			//사과가 없는경우 꼬리 줄어들기
			if(filed[nowX][nowY] != 1) {
				SnakeBody sb = snakes.get(0);
				snake[sb.getX()][sb.getY()] = 0;
				snakes.remove(0);
			}
			//현재값으로 초기화
			x = nowX;
			y = nowY;
			
			//방향 전환
			if(direct[time].equals("L")) {
				location = setLocation(location, -1);
			} else if(direct[time].equals("D")) {
				location = setLocation(location, 1);
			}
		}
	
		
		System.out.println(time);
		
	}

	private static int setLocation(int location, int direct) {
		int result = location + direct;
		
		if(result < 0) {
			result = 3;
		} else if(result > 3) {
			result = 0;
		}
		return result;
	}

}
