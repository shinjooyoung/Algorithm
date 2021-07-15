package study;

import java.util.Arrays;

public class countingSort {

	public static void main(String[] args) {
		int[] array = {7,5,9,0,3,1,6,2,9,1,4,8,0,5,2};
		
		Arrays.sort(array);

		int max = array[array.length-1];
		int[] result = new int [max+1];
		
		for(int num : array) {
			result[num] = result[num] + 1;
		}
		
		for(int num : array) {
			System.out.print(num + " ");			
		}

	}

}
