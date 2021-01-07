package study;

public class QuickSort {


	
	public static  void quickSort(int left, int right, int[] arr) {
		
		if(left < right) {
			int p = partition(arr, left, right);	
			
			QuickSort.quickSort(left, p-1, arr);
			QuickSort.quickSort(p+1,right, arr);
		}
	}
	
	
	private static int partition(int[] arr, int left, int right) {
		//오른쪽이 기준값이 됨
		int pivot = arr[right];
		int i = left -1;
		//왼쪽부터 오른쪽까지의 숫자를 피벗과 비교 피벗값보다 작은 값은 왼쪽으로 보냄
		for(int j = left; j < right; j++) {
			if(arr[j] < pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[right];
		arr[right] = arr[i+1];
		arr[i+1] = temp;
		
		return i+1;
	}

	public static void main(String[] args) {
		// 다음 숫자들을 오름차순으로 정렬하느 프로그램을 작성하세요
		// 1 10 5 8 7 6 4 3 2 9
		
		int[] arr = {1,10,5,8,7,6,4,3,2,9};
		

		
		QuickSort quik = new QuickSort();
		
		quickSort(0, arr.length-1, arr);
		
		for(int num : arr) {
			System.out.print(num);
		}
	}
}
