package study;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class findPart {

	public static void main(String[] args) {
		//5
		//8 3 7 9 2
		// 2 3 7 8 9
		
		//3
		//5 7 9
		
//		System.out.println(1/2);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[] parts = new Integer[n];
		
		for(int i = 0; i < n; i++) {
			parts[i] = sc.nextInt();
		}
		
		Arrays.sort(parts);
		
		int m = sc.nextInt();
		
		for(int i = 0; i < m; i++) {
			int result = searchPart(parts, 0,n-1, sc.nextInt());
			
			if(result  == 9999) {
				System.out.println("no");
			} else {
				System.out.println("yes");
			}
		}
	}

	private static int searchPart(Integer[] parts, int start, int end, int part) {
		int center = (start+end) / 2;
		
		if(parts[center]== part) {
			return center;
		} else {
			if(start < end) {
				 if(parts[center] > part) {
					return searchPart(parts,start,center-1, part);
				} else {
					return searchPart(parts,center+1,end, part);
				}
			} else {
				return 9999;
			}
			
		}
	}

}
