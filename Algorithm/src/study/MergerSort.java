package study;

public class MergerSort {

	
	public static void main(String[] args) {
		// 다음 숫자들을 오름차순으로 정렬하느 프로그램을 작성하세요
		// 1 10 5 8 7 6 4 3 2 9
		
		int[] arr = {1,10,5,8,7,6,4,3,2,9};
		int[] sortArr = new int[arr.length];
		try {
			mergerSort(arr,0,arr.length-1, sortArr);
			
		} catch (Exception e) {
			System.out.println("e :: " + e.getStackTrace());
		}
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
		
	}

	private static void mergerSort(int[] arr, int l, int r, int[] sortArr) throws Exception{
		
		if(l < r) {
			int middle = (l+r)/2;
			mergerSort(arr,l,middle,sortArr);
			mergerSort(arr,middle+1,r,sortArr);
			
			marge(arr,l,middle,r,sortArr);
		}
		
	}

	private static void marge(int[] arr, int l, int middle, int r, int[] sortArr) throws Exception{
		int i = l, j = middle+1;
		int k = l;
		System.out.println("i " + i );
		System.out.println("middle " + middle);
		System.out.println("j " + j);
		System.out.println("r " + r);
		

	
		while(i <= middle && j  <= r) {
			if(arr[i] > arr[j]) {
				sortArr[k] = arr[j];
				j++;
			} else {
				sortArr[k] = arr[i];
				i++;
			}
			k++;
		}
		if(i <= middle) {
			for(int a = i; a <= middle; a++) {
				sortArr[k] = arr[a];
				k++;
			}
		} else if (j <= r) {
			for(int a = j; a <= r; a++) {
				sortArr[k] = arr[a];
				k++;
			}
		}
		
		for(int c = l; c <= r; c++) {
			arr[c] = sortArr[c];
		}
		for(int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.println("-----------------------");
	}

}
