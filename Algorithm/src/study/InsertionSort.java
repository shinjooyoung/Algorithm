package study;

public class InsertionSort {

	public static void main(String[] args) {
		// 다음 숫자들을 오름차순으로 정렬하느 프로그램을 작성하세요
		// 1 10 5 8 7 6 4 3 2 9
		
		int[] array = {1,10,5,8,7,6,4,3,2,9};
		int temp = 0;
		
		for(int i = 0; i < array.length - 1; i++) {
			int j = i;
			while(array[j] > array[j+1]) {
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
				if(j != 0) {
					j--;
				}
			}
		}
		
		for(int num : array) {
			System.out.println(num);
		}

		

	}

}
