package study;

import java.util.Scanner;

public class GameDevelop {
	
	static int[] x = {0,-1,0,1};
	static int[] y = {-1,0,1,0};
	static int a;
	static int b;
	static int n;
	static int m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		a = sc.nextInt();
		b = sc.nextInt();
		
		int location = sc.nextInt();
		
		int[][] map = new int[50][50];
		int[][] load = new int[50][50];
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		//시작시간
		long beforeTime = System.currentTimeMillis();
		
		//1이 바다, 0이 육지
		
		//1. location 기준으로 반시계 방향으로 갈곳을 정한다.
		
		
		//2. 왼쪽방향에 가보지 않은 칸이 존재 하면 회전하고 한칸 전진, 왼쪽 방향을 가본곳이라면 회전만 하고 1단계로
		
		
		//3. 네 방향 모두 이미 가본칸이거나 바다로 되있을 경우 바라보는 칸을 유지한 상태로 뒤로 한칸 뒤쪽이 바다인 칸이면 종료
		
		load[a][b] = 1;
		int result = 1;
		int turnCheck = 0;
		while(true) {
			
			location = setLocation(location);
			turnCheck++;
			int ax = a + x[location];
			int by = b + y[location];
			
			if(ax >= 0 && ax >= 0) {
				if(map[ax][by]==0 && load[ax][by]==0) {
					load[ax][by] = 1;
					a= ax;
					b = by;
					turnCheck = 0;
					result++;
				}
			}
			
			if(turnCheck == 3) {
				int tempLocation = location;
				setLocation(tempLocation);
				setLocation(tempLocation);
				int tempA = a + x[tempLocation];
				int tempB = b + y[tempLocation];
				if(map[tempA][tempB] == 1) {
					break;
				}
				a= tempA;
				b = tempB;
				turnCheck = 0;
			}
		}
		
		System.out.println(result);
		//종료 시간
		long afterTime = System.currentTimeMillis();
		//시간 차
		long secDiffTime = (afterTime - beforeTime)/1000;
		
		System.out.println("시작(s) : " + beforeTime);
		System.out.println("종료(s) : " + afterTime);
		System.out.println("시간차이(s) : " + secDiffTime);
	}

	private static int setLocation(int location) {
		
		if(location >= 3 ) {
			location = 0;
		} else {
			location++;
		}
		return location;
	}

}
