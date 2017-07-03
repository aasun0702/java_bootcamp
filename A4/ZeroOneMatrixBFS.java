package A4;

import java.util.ArrayDeque;
import java.util.Deque;

public class ZeroOneMatrixBFS {
	public int[][] updateMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return matrix;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		Deque<int[]> q = new ArrayDeque<>();

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					q.offer(new int[] { i, j });
				} else {
					matrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		while (!q.isEmpty()) {
			int[] t = q.poll();
			for (int k = 0; k < 4; k++) {
				int x = t[0] + dx[k];
				int y = t[1] + dy[k];
				if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[t[0]][t[1]] + 1) {
					continue;
				}
				matrix[x][y] = matrix[t[0]][t[1]] + 1;
				q.offer(new int[] { x, y });
			}
		}
		return matrix;
	}
}
