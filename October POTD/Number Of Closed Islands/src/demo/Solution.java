package demo;

public class Solution {
	public int closedIslands(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			dfs(grid, i, 0);
			dfs(grid, i, n - 1);
		}
		for (int j = 0; j < m; j++) {
			dfs(grid, 0, j);
			dfs(grid, m - 1, j);
		}
		int count = 0;
		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (grid[i][j] == 0) {
					count++;
					dfs(grid, i, j);
				}
			}
		}
		return count;
	}

	private void dfs(int[][] grid, int row, int col) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 1) {
			return;
		}
		grid[row][col] = 1;
		dfs(grid, row + 1, col);
		dfs(grid, row - 1, col);
		dfs(grid, row, col + 1);
		dfs(grid, row, col - 1);
	}
}