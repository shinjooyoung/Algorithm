package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Food2 implements Comparable<Food2>{
	int time;
	int num;
	
	Food2(int time, int num) {
		this.time = time;
		this.num = num;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public int compareTo(Food2 others) {
		return Integer.compare(this.time, others.num);
	}
}

class Solution2 {
	public int solution(int[] food_time, long k) {
		int answer = 0;
		
		// 각 객체 생성
		long sum = 0;
		for(int i = 0; i < food_time.length; i++) {
			sum += food_time[i];
		}
		// 중단시간보다 총 시간이 적으면 -1 리턴
		if(sum < k) {
			return -1;
		}
		
		PriorityQueue<Food2> pq = new PriorityQueue<Food2>();
		
		for(int i = 0; i < food_time.length; i++) {
			pq.add(new Food2(food_time[i],i+1));
		}
		
		sum = 0;
		long previous = 0; //직전에 다 먹음 음식 시간
		long length = food_time.length; // 음식 개수
		while(sum +  (pq.peek().getTime()- previous) * length <= k) {
			int now =  pq.poll().getTime();
			sum += (now - previous) * length;
			previous = now;
			length--;
		}
		ArrayList<Food2> arr = new ArrayList<Food2>();
		while(!pq.isEmpty()) {
			arr.add(pq.poll());
		}
		
		Collections.sort(arr, new Comparator<Food2>() {
			@Override
			public int compare(Food2 arg0, Food2 arg1) {
				return Integer.compare(arg0.num, arg1.num);
			}
		});
		
	
		
		return answer+1;
	}
	
}

public class MuziMukbangLive2 {
	// 재시도
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		int[] food_time = {3,1,2};
		int answer = solution.solution(food_time, 5);
		System.out.println(answer);
		
	}

}