package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class standardSort {

	public static void main(String[] args) {
		//문제
		//N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
		//입력
		//첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
		//출력
		//첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
		Scanner sc = new Scanner(System.in);
//		int[] nums = new int[sc.nextInt()];
//		for(int i = 0; i < nums.length; i++) {
//			int num = sc.nextInt();
//			if(num > 0 && num <= 1000000) {
//				nums[i] = num;
//			}
//		}
		
		List<Integer> arr = new ArrayList<Integer>();
		int nums = sc.nextInt();
		for(int i = 0; i <nums; i++) {
			int num = sc.nextInt();
			if(num > 0 && num <= 1000000) {
				arr.add(num);
			}			
		}
		Collections.sort(arr);
//		quickSort(0,nums.length-1,nums);
	
		for(int num : arr) {
			System.out.println(num);
		}
	}

	private static void quickSort(int left, int right, int[] nums){
		if(left < right) {
			int p = partition(left,right,nums);
			quickSort(left, p-1,nums);
			quickSort(p+1,right ,nums);
		}
		
	}

	private static int partition(int left, int right, int[] nums){
		int i = left -1;
		int pivot = nums[right];
		for(int j = left; j < right; j++) {
			if(nums[j] < pivot) {
				i++;
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
			}
		}
		int temp = nums[right];
		nums[right] = nums[i+1];
		nums[i+1] = temp;
		return i+1;
	}

}
