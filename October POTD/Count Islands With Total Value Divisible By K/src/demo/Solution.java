package demo;

public class Solution {
	public long dfs(int[][] grid, int row, int col) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 0) {
			return 0;
		}
		long ans = grid[row][col];
		grid[row][col] = 0;
		ans += dfs(grid, row + 1, col);
		ans += dfs(grid, row - 1, col);
		ans += dfs(grid, row, col + 1);
		ans += dfs(grid, row, col - 1);
		return ans;
	}

	public int courtIslands(int[][] grid, int k) {
		int m = grid.length;
		int n = grid[0].length;
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] > 0) {
					long fish = dfs(grid, i, j);
					if (fish % k == 0) {
						count++;
					}
				}
			}
		}
		return count;
	}
}
