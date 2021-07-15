package study;

import java.util.Scanner;

public class GenerateTeam {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] teams = new int[n+1];
		for(int i = 1; i <= n; i++) {
			teams[i] = i;
		}
		
		for(int i =0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			//0 팀합치기
			//1 같은팀 여부 확인
			
			if(a == 0) {
				unionTeam(teams, b, c);
			} else {
				b = findTeam(teams, b);
				c = findTeam(teams, c);
				
				if(b == c) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}
			
		}

	}

	private static int findTeam(int[] teams, int x) {
		if(teams[x] == x ) {
			return x;
		} else {
			teams[x] = findTeam(teams, teams[x]);
			return teams[x];
		}
	}

	private static void unionTeam(int[] teams, int a, int b) {
		int x = findTeam(teams, a);
		int y = findTeam(teams, b);
		if(x > y) {
			teams[x] = y;
		} else {
			teams[y] = x;
		}
	}

}
