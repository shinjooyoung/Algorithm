package study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologySort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		int[] nums = new int[n+1];
		
		for(int i = 0 ; i <= n; i++) {
			arr.add(new ArrayList<Integer>());
		}
		
		for(int i = 1; i <= m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr.get(a).add(b);
			nums[b]+=1; 
		}
		
		ArrayList<Integer> result = topologySort(arr, nums);
		
		for(int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
		
		
	}

	private static ArrayList<Integer> topologySort(ArrayList<ArrayList<Integer>> arr, int[] nums) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int standard = 0;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] ==0) {
				standard = i;
			}
		}
		
		Queue<Integer> q =  new LinkedList<Integer>();
		
		q.add(standard);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			result.add(now);
			
			ArrayList<Integer> linked = arr.get(now);
			
			for(int i = 0; i < linked.size(); i++) {
				nums[linked.get(i)] -= 1;
				
				if(nums[linked.get(i)] ==0) {
					q.add(linked.get(i));					
				}
			}
			
		}
		return result;
	}

}
