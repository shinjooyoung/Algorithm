package study;

public class InsertionSort {

	public static void main(String[] args) {
		// ���� ���ڵ��� ������������ �����ϴ� ���α׷��� �ۼ��ϼ���
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
//			System.out.println(num);
		}
		
		//���� ���� ���� ���
		int[] array2 = {26,5,37,1,61,11,59,15,48,19};
		int temp2 = 0;
		
		for(int i = 0; i < array2.length-1; i++) {
			for(int k = 0; k < i; k++) {
				System.out.print(array2[k] + " ");
			}
			System.out.println();
			int j = i;
			while(array2[j] > array2[j+1]) {
				temp2 = array2[j];
				array2[j] = array2[j+1];
				array2[j+1] = temp2;
				if(j != 0) {
					j--;
				}
			}
			
		}

		

	}

}
