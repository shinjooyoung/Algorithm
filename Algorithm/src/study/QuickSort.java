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
		//�������� ���ذ��� ��
		int pivot = arr[right];
		int i = left -1;
		//���ʺ��� �����ʱ����� ���ڸ� �ǹ��� �� �ǹ������� ���� ���� �������� ����
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
		// ���� ���ڵ��� ������������ �����ϴ� ���α׷��� �ۼ��ϼ���
		// 1 10 5 8 7 6 4 3 2 9
		
		int[] arr = {1,10,5,8,7,6,4,3,2,9};
		

		
		QuickSort quik = new QuickSort();
		
		quickSort(0, arr.length-1, arr);
		
		for(int num : arr) {
			System.out.print(num);
		}
	}
}
