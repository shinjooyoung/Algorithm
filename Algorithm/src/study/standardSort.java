package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class standardSort {

	public static void main(String[] args) {
		//����
		//N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		//�Է�
		//ù° �ٿ� ���� ���� N(1 �� N �� 1,000,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ���ڰ� �־�����. �� ���� ������ 1,000,000���� �۰ų� ���� �����̴�. ���� �ߺ����� �ʴ´�.
		//���
		//ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.
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
