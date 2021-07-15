package study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LowResult {

	public static void main(String[] args) {
		// 성적이 낮은 순대로
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		

		long beforeTime = System.currentTimeMillis();
		
		
		Integer[] arr = new Integer[num];
		Map<Integer,String> data = new HashMap<Integer, String>();
		sc.nextLine();		
		for(int i = 0; i < num; i++) {
			String name = sc.next();
			int a = sc.nextInt();
			arr[i] = a;
			data.put(a, name);
		}
		
		Arrays.sort(arr);
		
		
		for(int num2 : arr) {
			System.out.print(data.get(num2) + " ");			
		}
		
		
		
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime)/1000;
		
		System.out.println("시작(s) : " + beforeTime);
		System.out.println("종료(s) : " + afterTime);
		System.out.println("시간차이(s) : " + secDiffTime);
		
	}

}
