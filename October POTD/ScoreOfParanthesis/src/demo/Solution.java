package demo;

import java.util.Stack;

public class Solution {
	public int scoreOfParantheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.push(0);
			} else {
				int current = stack.pop();
				int score = current == 0 ? 1 : 2 * current;
				if (!stack.isEmpty()) {
					int parent = stack.pop();
					stack.push(parent + score);
					result += score;
				}
			}
		}
		return result;
	}
}
