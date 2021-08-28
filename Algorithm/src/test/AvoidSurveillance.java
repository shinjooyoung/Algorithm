package test;

import java.util.Scanner;

public class AvoidSurveillance {

	static int n;
	static String[][] filed, obstacle;
	static boolean[][] check;
	static boolean result = false;
	static int[] nx = {1,-1,0,0};
	static int[] ny = {0,0,1,-1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		filed = new String[n][n];
		obstacle = new String[n][n];
		check = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				String str = sc.next();
				filed[i][j] = str;
			}
			sc.nextLine();
		}
		
		per(0);
		
		if(result) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static void per(int cnt) {
		if(cnt ==3) {
			confirm();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				String str = filed[i][j];
				
				if(str.equals("X") && !check[i][j]) {
					check[i][j] = true;
					filed[i][j] = "O";
					per(cnt+1);
					if(result) return;
					filed[i][j] = "X";
					check[i][j] = false;
				}
			}
		}
		
	}

	private static void confirm() {
		boolean confirmCheck = false;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				String teacher = filed[i][j];
				
				if(teacher.equals("T")) {
					for(int k = 0; k < 4; k++) {
						confirmCheck = dfs(i+nx[k], j+ny[k], nx[k], ny[k]);
						if(confirmCheck) return;
					}
				}
			}
		}
		result = true;
	}

	private static boolean dfs(int i, int j, int x, int y) {
		
		if(i >= 0 && j >= 0 && i < n && j < n) {
			String str = filed[i][j];
			if(str.equals("O")) {
				return false;
			} else if(str.equals("S")) {
				return true;
			} else {
				return dfs(i+x, j+y, x, y);
			}
			
		}
		return false;
	}
	

}
