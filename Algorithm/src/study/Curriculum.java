package study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Curriculum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		ArrayList<ArrayList<Integer>> arrs = new ArrayList<ArrayList<Integer>>();
		int[] total = new int[n+1];
		int[] check = new int[n+1];
		for(int i = 0; i <= n; i++) {
			arrs.add(new ArrayList<Integer>());
		}
		
		for(int i = 1; i <= n; i++) {
			total[i] = sc.nextInt();
			while(true) {
				
				int num = sc.nextInt();
				if(num == -1) {
					break;
				} else {
					check[i] += 1;
					arrs.get(num).add(i);
				}
				
			}
		}
		
//		for(int i = 1; i <= n; i++) {
//			System.out.println(check[i]);
//		}
		
		int[] result = topology(arrs, check, total, n);
		
		for(int i = 1; i <= n; i++) {
			System.out.println(result[i]);
		}
		
	}

	private static int[] topology(ArrayList<ArrayList<Integer>> arrs,int[] check, int[] total,int num) {
		int standard = 1;
		int[] result = new int[num+1];
		for(int i = 1; i <= num; i++) {
			if(check[i] == 0 ) {
				standard = i;
				break;
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(standard);
		while(!q.isEmpty()) {
			int now = q.poll();
			int nowCost = total[now];
			result[now] = nowCost;
			ArrayList<Integer> arr = arrs.get(now);
			
			for(int i = 0; i < arr.size(); i++) {
				int link = arr.get(i);
				check[link] -= 1;
				
				if(check[link] == 0) {
					q.add(link);
					total[link] = Math.max(total[link], total[link] + nowCost);
				}
			}
		}
		return result;
	}

}
