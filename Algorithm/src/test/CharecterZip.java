package test;

import java.util.Scanner;

public class CharecterZip {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String  s = sc.next();
		int result = solution(s);
		System.out.println(result);

	}

	private static int solution(String s) {
		int answer = s.length();
		
		for(int i = 1; i <= s.length() /2; i++) {
			int len = s.length();
			int pos = 0;
			for(;pos + i <= s.length();) {
				String now = s.substring(pos, pos+i);
				int cnt = 0;
				pos += i;
			
				for(; pos + i <= s.length();) {
					String next = s.substring(pos, pos+i);
					if(now.equals(next)) {
						cnt++;
						pos +=i;
					} else {
						break;
					}
				}
				len -= cnt*i;
				if(cnt > 0) {
					len += (int)(Math.log10(cnt) + 1);
				}
			}
			
			answer = Math.min(answer, len);
		}
		return answer;
	}

}
