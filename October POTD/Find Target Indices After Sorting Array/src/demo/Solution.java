package demo;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> targetIndices(int[] nums, int target) {
		int n = nums.length;
		int start = 0, cnt = 0;
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (nums[i] < target) {
				start++;
			}
			if (nums[i] == target) {
				cnt++;
			}
		}
		if (cnt == 0) {
			return result;
		}
		for (int i = 1; i <= cnt; i++) {
			result.add(start++);
		}
		return result;
	}
}