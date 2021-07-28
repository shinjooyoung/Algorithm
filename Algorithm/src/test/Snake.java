package test;

import java.util.Scanner;

public class Snake {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] filed = new int[n][n];
		
		int[][] snake = new int[n][n];
		
		
		
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
		int snakeX = 0;
		int snakeY = 0;
		
		snake[x][y] = 1;
		int time = 0;
		int location = 0;
		for(int i = 0; i < l; i++) {
			int c = sc.nextInt();
			String direct = sc.next();
			
			boolean loadcheck = false;
			for(int j = 0; j < c; j++) {
				time++;
				int nowX  = x + xn[location];
				int nowY = y + yn[location];
				if(nowX >= n || nowY >=n || nowX < 0 || nowY < 0 || snake[nowX][nowY] == 1) {
					loadcheck = true;
					break;
				}
				// 머리부터 
				snake[nowX][nowY] = 1;
				
				//사과가 없는경우 꼬리 줄어들기
				if(filed[nowX][nowY] != 1) {
					snake[snakeX][snakeX] = 0;
				}
				System.out.println("x :: " + nowX + " y :: " + nowY);
				System.out.println("사과 :: " + filed[nowX][nowY]);
				//현재값으로 초기화
				x = nowX;
				y = nowY;
			}
			if(loadcheck) {
				break;
			}
			
			//방향 전환
			if(direct.equals("L")) {
				location = setLocation(location, -1);
			} else if(direct.equals("D")) {
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
