package study;

import java.util.Arrays;
import java.util.Scanner;

public class SortThreeNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int[] numbers = new int[3];
		for(int i = 0; i < 3; i++) {
			numbers[i] = sc.nextInt();
		}
		int min = 0;
		int temp =0;
		//���� ����
		for(int i = 0; i < numbers.length; i++) {
			int index = 0;
			min = 99;
			for(int j = i; j < numbers.length; j++) {
				if(min > numbers[j]) {
					min = numbers[j];
					index = j;
				}
			}
			temp = numbers[i];
			numbers[i] = numbers[index];
			numbers[index] = temp;
		}
		
//		���ѹ��	
//		Arrays.sort(numbers);
//		
		for(int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i]);
			if(i != numbers.length-1) {				
				System.out.print(" ");
			}
		}

	}

}
