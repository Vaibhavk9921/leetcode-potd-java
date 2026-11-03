package demo;

public class Solution {
	public int minMoves(int[] nums) {
		int n = nums.length;
		long max = Integer.MIN_VALUE;
		long moves = 0;
		for (int num : nums) {
			if (num > max) {
				max = num;
			}
			for (int i = 0; i < n; i++) {
				moves += max - nums[i];
			}
		}
		return (int) moves;
	}
}