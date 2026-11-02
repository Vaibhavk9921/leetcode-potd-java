package demo;

import java.util.Arrays;

public class Solution {
	public int minMoves2(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		int median = nums[n / 2];
		long moves = 0;
		for (int num : nums) {
			moves += Math.abs(median - num);
		}
		return (int) moves;
	}
}