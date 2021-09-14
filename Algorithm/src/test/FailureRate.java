package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FailureRate {
	
	static class Solution {
		
		static class Failure implements Comparable<Failure>{
			int num;
			double failureRate;
			
			Failure(int num, double failureRate) {
				this.num = num;
				this.failureRate = failureRate;
			}

			@Override
			public int compareTo(Failure others) {
				
				return Double.compare(this.failureRate, others.failureRate);
			}
		}
		
		public static int[] solution(int N, int[] stages) {
			int[] answer = new int[N];
			
			int[] checkStages = new int[N+1];
			int total = 0;
			
			for(int i = 0; i < stages.length; i++) {
				if(N < stages[i]) {
					total ++;
					continue;
				}
				checkStages[stages[i]] +=1;
				total ++;
			}
			
			List<Failure> list = new ArrayList<>();
			
			
			for(int i = 1; i <= N; i++) {
				total -= checkStages[i-1]; 
                double f= 0;
                if(checkStages[i] != 0) {
                   f =(double)checkStages[i] / total; 
                }
				
				list.add(new Failure(i, f ));
			}
			
			Collections.sort(list, Collections.reverseOrder());
			
			for(int i = 0; i < list.size(); i++) {
				answer[i] = list.get(i).num;
			}
			
			return answer;
		}
	}

	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2,1,2,6,2,4,3,3};
		int[] answer = Solution.solution(N, stages);
		
		for(int num : answer) {
			System.out.print(num + " ");
		}

	}

}
