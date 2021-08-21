package test;

public class Bracket {

	public static class Solution {
		public static String solution(String p) {
			String answer = "";
			// 올바른 괄호 문자열 확인
			if (confirmStr(p))
				return p;
			answer = generateStr(p);
			return answer;
		}

		private static String generateStr(String str) {
			// 빈 문자열 반환

			if (str.equals("")) {
				return "";
			}

			String u = "";
			String v = "";
			int left = 0;
			int right = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					left++;
				} else {
					right++;
				}
				u += Character.toString(str.charAt(i));
				if (left == right) {
					if (i < str.length() - 1) {
						v = str.substring(i + 1, str.length());
					}
					break;
				}
			}
			if (confirmStr(u)) {
				u += generateStr(v);
			} else {
				String emptyStr = "(";
				emptyStr += generateStr(v);
				emptyStr += ")";
				for (int i = 1; i < u.length() - 1; i++) {
					if (u.charAt(i) == '(') {
						emptyStr += ")";
					} else {
						emptyStr += "(";
					}
				}
				return emptyStr;
			}
			return u;
		}

		private static boolean confirmStr(String str) {
			boolean result = true;
			int left = 0;
			int right = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					left++;
				} else {
					right++;
				}
				if (left < right) {
					result = false;
					break;
				}
			}
			return result;
		}
	}

	public static void main(String[] args) {
		String result = Solution.solution("(()())()");
		System.out.println(result);

	}

}
