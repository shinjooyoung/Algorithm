package study;

public class BubbleSort {

	public static void main(String[] args) {
		// ���� ���ڵ��� ������������ �����ϴ� ���α׷��� �ۼ��ϼ���
		// 1 10 5 8 7 6 4 3 2 9
		int[] array = {1,10,5,8,7,6,4,3,2,9};
		int temp = 0;
		
		for(int i = 0; i < array.length; i++ ) {
			for(int j = 0; j < array.length-i-1; j++ ) {
				if(array[j] > array[j + 1] ) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		for(int num : array) {
			System.out.println(num);
		}

	}

}
