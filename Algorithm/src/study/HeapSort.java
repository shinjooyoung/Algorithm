package study;

public class HeapSort {

	
	public static void main(String[] args) {
		// 다음 숫자들을 오름차순으로 정렬하느 프로그램을 작성하세요
		// 1 10 5 8 7 6 4 3 2 9
		int number = 9;
		int[] heap = {1,10,5,8,7,6,4,3,2};
		//{10,1,5,8,7,6,4,3,2};
			// heap구조 변경
		for(int i = 1; i < number; i++) {
			int c= i;
			do {
				int root = (c - 1) / 2;
				if(heap[root] < heap[c]) {
					int temp = heap[root];
					heap[root] = heap[c];
					heap[c] = temp;
				}
				c = root;
			}
			while(c != 0);
		}
		for(int i = number-1; i >= 0; i--) {
			int temp = heap[0];
			heap[0] = heap[i];
			heap[i] = temp;
			int root = 0;
			int c = 1;
			do {
				c = 2 * root + 1;
				if(heap[c] < heap[c + 1] && c < i -1) {
					c++;
				}
				//f루트보다 자식이 크면
				if(heap[root] < heap[c] && c < i) {
					int temp2 = heap[root];
					heap[root] = heap[c];
					heap[c] = temp2;
					
				}
				root = c;
			}
			while(c < i);
		}
			
		
	}
}
