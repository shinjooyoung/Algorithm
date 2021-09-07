package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Migration {

	
	public static class Contry{
		int a;
		int b;
		int total;
		
		Contry(int a, int b, int total){
			this.a = a;
			this.b = b;
			this.total = total;
		}
		
	}
	static int n,l,r,result;
	
	static int[][] city;
	static int[] x = {1,-1,0,0};
	static int[] y = {0,0,1,-1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		result = 0;
		city = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				city[i][j] = sc.nextInt();
			}		
		}
		boolean check = true;
		while(check) {
			boolean[][] cityCheck = new boolean[n][n];
			boolean whileChekc = false;
	
			//while 문으로 해야함 하번돌떄 한번만 체크끝에서 
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					
					// 연합 체크
					if(!cityCheck[i][j]) {
						//연합 리스트
						List<Contry> list = new ArrayList<Contry>();
						list.add(new Contry(i, j, city[i][j]));
						cityCheck[i][j] = true;
						//연합 생성
						setTeam(i, j, list, cityCheck);
						
						// 연합이 있는 경우 이동
						if(list.size() > 1) {
							whileChekc = true;
							movePopulation(list);
						} else {
							cityCheck[i][j] = false;
						}
						
					}
					
					
				}		
			}
			
			check = whileChekc;
			
			if(whileChekc) {
				result++;
			} 
		}
		
		System.out.println(result);
	}
	
	private static void setTeam(int i, int j, List<Contry> list, boolean[][] cityCheck) {

		
		for(int k = 0; k < 4; k++) {
			if(i+x[k] >= 0 && j+y[k] >= 0 && i+x[k] < n && j+y[k] < n && !cityCheck[i+x[k]][j+y[k]]) {
				int population = Math.abs(city[i][j] - city[i+x[k]][j+y[k]]);
				if(population >= l && population <= r) {
					list.add(new Contry(i+x[k], j+y[k],city[i+x[k]][j+y[k]]));
					cityCheck[i+x[k]][j+y[k]] = true; 
					setTeam(i+x[k], j+y[k], list, cityCheck);
				}
				
			}

		}
	}

	private static void movePopulation(List<Contry> list) {
		
		
		int nums = 0;
		for(int i = 0; i < list.size(); i++) {
			nums += list.get(i).total;
			
 		}
		int num = nums / list.size();
		for(int i = 0; i < list.size(); i++) {
			int a = list.get(i).a;
			int b = list.get(i).b;
			
			city[a][b] = num;
 		}
		
	}

}
