package study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class Class implements Comparable<Class> {

	int result;
	String name;
	
	/**
	 * @return the result
	 */
	public int getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(int result) {
		this.result = result;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Class other) {
		return this.result - other.result;
	}
	
	
}

public class LowResult2 {

	public static void main(String[] args) {
		// 성적이 낮은 순대로
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		

		long beforeTime = System.currentTimeMillis();
		
		
		Class[] arr = new Class[num];
		sc.nextLine();		
		for(int i = 0; i < num; i++) {
			Class cl = new Class();
			cl.setName(sc.next());
			cl.setResult(sc.nextInt());
			arr[i] = cl;
		}
		
		Arrays.sort(arr);
		
		for(Class num2 : arr) {
			System.out.print(num2.getName() + " ");			
		}
		
		
		
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime)/1000;
		
		System.out.println("시작(s) : " + beforeTime);
		System.out.println("종료(s) : " + afterTime);
		System.out.println("시간차이(s) : " + secDiffTime);
		
	}

}
