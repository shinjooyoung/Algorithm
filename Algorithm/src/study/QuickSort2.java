package study;

public class QuickSort2 {




	public static void main(String[] args) {
		// 다음 숫자들을 오름차순으로 정렬하느 프로그램을 작성하세요
		// 1 10 5 8 7 6 4 3 2 9
		
		int[] arr = {1,10,5,8,7,6,4,3,2,9};
		
		quickSort(arr, 0, arr.length-1);
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
		

	}

	private static void quickSort(int[] arr, int l, int r) {
		
		if(l < r) {
			int p = partition(arr, l, r);
			
			quickSort(arr, l, p-1);
			quickSort(arr, p+1, r);
		}
	}

	private static int partition(int[] arr, int l, int r) {
		
		int  j = l -1;
		int pivot = arr[r];
		
		for(int i = l; i < r; i++) {
			if(arr[i] < pivot) {
				j++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[r];
		arr[r] = arr[j+1];
		arr[j+1] = temp;
		return j+1;
	}

}
