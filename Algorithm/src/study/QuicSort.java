package study;

public class QuicSort {

	public static void main(String[] args) {
		int[] array = {7,5,0,9,3,1,6,2,4,8};
		
		quickSort(array,0,array.length-1);
		
		for(int num : array) {
			System.out.print(num + " ");			
		}
	}

	private static void quickSort(int[] array, int l, int r) {
		if(l < r) {
			int pvot = partition(array, l, r);
			
			quickSort(array, l, pvot-1);
			quickSort(array, pvot+1, r);
		}
	}

	private static int partition(int[] array, int l, int r) {
		int a = l -1;
		int value = array[r];
		for(int i = l; i < r; i++) {
			if (value > array[i]) {
				a++;
				int temp = array[i];
				array[i] = array[a];
				array[a] = temp;
			}
		}
		int temp = array[r];
		array[r] = array[a+1];
		array[a+1] = temp;
		
		return a+1;
	}

}