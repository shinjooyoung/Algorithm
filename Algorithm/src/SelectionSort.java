
public class SelectionSort {

	public static void main(String[] args) {
		// ���� ���ڵ��� ������������ �����ϴ� ���α׷��� �ۼ��ϼ���
		// 1 10 5 8 7 6 4 3 2 9
		
		int[] array = {1,10,5,8,7,6,4,3,2,9};
		int min, index =0, temp = 0;
		//ù��° ������ �ڿ� �ִ� ���� ���� ���� ���� ������ ����
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
