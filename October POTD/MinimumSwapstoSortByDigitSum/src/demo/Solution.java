package demo;

import java.util.Arrays;

class Solution {
	public int minSwaps(int[] nums) {
		int n = nums.length;
		int[][] arr = new int[n][3];
		for (int i = 0; i < n; i++) {
			arr[i][0] = nums[i];
			arr[i][1] = i;
			arr[i][2] = digitsSum(nums[i]);
		}
		Arrays.sort(arr, (a, b) -> {
			if (a[2] != b[2]) {
				return Integer.compare(a[2], b[2]);
			}
			return Integer.compare(a[0], b[0]);
		});
		boolean[] visited = new boolean[n];
		int swaps = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i] || arr[i][1] == i) {
				continue;
			}
			int cycleSize = 0;
			int j = i;
			while (!visited[j]) {
				visited[j] = true;
				j = arr[j][1];
				cycleSize++;
			}
			swaps += cycleSize - 1;
		}
		return swaps;
	}

	private int digitsSum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
}