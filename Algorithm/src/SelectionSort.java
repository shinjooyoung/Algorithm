
public class SelectionSort {

	public static void main(String[] args) {
		// 다음 숫자들을 오름차순으로 정렬하느 프로그램을 작성하세요
		// 1 10 5 8 7 6 4 3 2 9
		
		int[] array = {1,10,5,8,7,6,4,3,2,9};
		int min, index =0, temp = 0;
		//첫번째 값부터 뒤에 있는 값을 비교해 작은 값을 앞으로 보냄
		for(int i = 0; i < array.length; i++) {
			min = 999;
			for(int j = i; j < array.length; j++) {
				if(min > array[j]) {
					index = j;
					min = array[j];
				}
			}
			temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
		for(int num : array) {
			System.out.println(num);
		}

	}

}
