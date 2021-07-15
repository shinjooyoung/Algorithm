package study3;

import java.util.Scanner;

public class OnlynOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int num = 0;
		while(true) {
			int pop = n % k;
			num += pop;
			n = n-pop;
			if(n <= 1) {
				break;
			}
			n = n/k;
			num++;
		}
		//while문 처음에 나머지를 구할때 값이 1일경우 1이 반환됨 그래서 마지막 -1을 해줌
		System.out.println(num-1);
	}

}
