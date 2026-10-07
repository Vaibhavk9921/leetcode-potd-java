package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	private String s;
	private Set<String> result = new HashSet<>();

	private void dfs(int index, int removeLeft, int removeRight, StringBuilder current, int balance) {
		char ch = s.charAt(index);
		if (index == s.length()) {
			if (removeLeft == 0 && removeRight == 0 && balance == 0) {
				result.add(current.toString());
				return;
			}
		}
		if (Character.isLetter(ch)) {
			current.append(ch);
			dfs(index + 1, removeLeft, removeRight, current, balance);
			current.deleteCharAt(current.length() - 1);
		}
		if (ch == '(') {
			if (removeLeft > 0) {
				removeLeft--;
				dfs(index + 1, removeLeft, removeRight, current, balance);
				removeLeft++;
			}
			current.append(ch);
			balance++;
			dfs(index + 1, removeLeft, removeRight, current, balance);
			balance--;
			current.deleteCharAt(current.length() - 1);
		}
		if (ch == ')') {
			if (removeRight > 0) {
				removeRight--;
				dfs(index + 1, removeLeft, removeRight, current, balance);
				removeRight++;
			}
			if (balance > 0) {
				balance--;
				current.append(ch);
				dfs(index + 1, removeLeft, removeRight, current, balance);
				balance++;
				current.deleteCharAt(current.length() - 1);
			}
		}
	}

	public List<String> removeInvalidParantheses(String s) {
		this.s = s;
		result.clear();
		int removeLeft = 0;
		int removeRight = 0;
		int balance = 0;
		StringBuilder current = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				balance++;
			} else if (ch == ')' && balance > 0) {
				balance--;
			} else if (ch == ')' && balance == 0) {
				removeRight++;
			}
		}
		removeLeft = balance;
		dfs(0, removeLeft, removeRight, current, 0);
		return new ArrayList<String>(result);
	}
}
