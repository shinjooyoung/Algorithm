package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Food implements Comparable<Food>{
	int num;
	int cost;
	
	Food(int num, int cost){
		this.num = num;
		this.cost = cost;
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



	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}



	/**
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}



	@Override
	public int compareTo(Food arg0) {
//		if(this.cost < arg0.cost) {
//			return -1;
//		}
//		return 1;
		return Integer.compare(this.cost, arg0.cost);
	}
}

public class MuziMukbangLive {

	public static void main(String[] args) {
		int[] food_time = {3,1,2};
		
		long result = solution(food_time,5);

		System.out.println(result);
	}

	
	public static long solution(int[] food_time, long k) {
		long answer = 0;
		long sum = 0;
		
		for(int i = 0; i < food_time.length; i++) {
			sum += food_time[i];
		}
		
		if(sum < k) {
			return -1;
		}
		
		PriorityQueue<Food> pq = new PriorityQueue<Food>();
		
		for(int i = 0; i < food_time.length; i++) {
			pq.offer(new Food(i+1, food_time[i]));
		}
		
		
		long foodLength = food_time.length;
		long complateFood = 0;
		sum = 0;
		while(sum + (pq.peek().getCost() - complateFood) * foodLength <= k) {
			Food food = pq.poll();
			sum += (food.getCost() - complateFood) * foodLength;
			complateFood = food.getCost();
			foodLength--;
		}
		
		ArrayList<Food> arr = new ArrayList<Food>();
		while(!pq.isEmpty()) {
			arr.add(pq.poll());
		}
		
		Collections.sort(arr, new Comparator<Food>() {

			@Override
			public int compare(Food arg0, Food arg1) {
				return Integer.compare(arg0.num, arg1.num);
			}
		});
		Food resultFood = arr.get((int) ((k-sum) % foodLength));
		answer = resultFood.getNum();
		
		return answer;
	}
}