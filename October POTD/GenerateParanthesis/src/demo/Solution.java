package demo;

import java.util.ArrayList;
import java.util.List;

class Solution {
	void generate(List<String> result, StringBuilder current, int open, int close, int n) {
		if (open == n && close == n) {
			result.add(current.toString());
			return;
		}
		if (open < n) {
			current.append('(');
			generate(result, current, open + 1, close, n);
			current.deleteCharAt(current.length() - 1);
		}
		if (close < open) {
			current.append(')');
			generate(result, current, open, close + 1, n);
			current.deleteCharAt(current.length() - 1);
		}
	}

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		StringBuilder current = new StringBuilder();
		int open = 0;
		int close = 0;
		generate(result, current, open, close, n);
		return result;
	}
}