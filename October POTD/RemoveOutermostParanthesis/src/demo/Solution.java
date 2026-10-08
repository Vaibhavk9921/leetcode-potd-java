package demo;

public class Solution {
	public String removeOuterParantheses(String s) {
		StringBuilder result = new StringBuilder();
		int balance = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				if (balance > 0) {
					result.append(ch);
				}
				balance++;
			}
			if (ch == ')') {
				balance--;
				if (balance > 0) {
					result.append(ch);
				}
			}
		}
		return result.toString();
	}
}
