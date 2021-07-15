package study;

public class selectSort {

	public static void main(String[] args) {
		
		int[] array = {7,5,9,0,3,1,6,2,4,8};
		
		
		for(int i = 0; i < array.length; i++) {
			int min = 9999;
			int index = i;
			for(int j = i; j < array.length; j++) {
				if(min > array[j]) {
					min = array[j];
					index = j;
				}
			}
			int temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
		
		for(int num : array) {
			System.out.print(num + " ");			
		}

	}

}
