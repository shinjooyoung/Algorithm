package study;

public class MargeSort {

	public static void main(String[] args) {
		int[] array = {1,10,5,8,7,6,4,3,2,9};
		int[] result = new int[array.length];
		margeSort(array, result, 0, array.length-1);
		for(int num : array) {
			System.out.print(num + " ");			
		}
	}

	private static void margeSort(int[] array, int[] result, int l, int r) {
		
		if(l < r) {
			int p = (l + r) / 2;
			
			margeSort(array,result, l, p);
			margeSort(array,result, p+1, r);
			
			marge(array, result, l, r, p);
		}
		
	}

	private static void marge(int[] array, int[] result, int start, int end, int p) {
		
		int i = start;
		int k = start;
		int j = p+1;
		
		while(i <= p && j <= end) {
			if(array[i] < array[j]) {
				result[k++] = array[i++];
			} else {
				result[k++] = array[j++];
			}
		}
		
		if(j > end) {
			for(int l = i; l <= p; l++) {
				result[k++] = array[i++];
			}
		} else {
			for(int l = j; l <= end; l++) {
				result[k++] = array[j++];
			}
		}
		for(int l = start; l <= end; l++) {
			array[l] = result[l];
		}
		
		
	}

}
