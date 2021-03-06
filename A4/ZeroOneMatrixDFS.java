package A4;

import java.util.List;

public class ZeroOneMatrixDFS {
	int row;
	int col;

	int[] dx = { 1, -1, 0, 0 };
	int[] dy = { 0, 0, 1, -1 };

public List<List<Integer>> updateMatrix(List<List<Integer>> matrix){
	if(matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0){
		return matrix;
	}
	row = matrix.size();
	col = matrix.get(0).size();
	preSet(matrix);
	
	for(int i = 0;i < row;i++){
		for(int j = 0;j < col;j++){
			if(matrix.get(i).get(j) == 1){
				helper(matrix , 1 , i , j);
			}
		}
	}
	return matrix;
}

	public void preSet(List<List<Integer>> matrix) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix.get(i).get(j) == 0) {
					continue;
				}

				boolean flag = false;
				for (int k = 0; k < 4; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					if (x < 0 || x >= row || y < 0 || y >= col) {
						continue;
					}
					flag |= matrix.get(x).get(y) == 0;
				}
				if (!flag) {
					matrix.get(i).set(j, Integer.MAX_VALUE);
				}
			}
		}
	}

	public void helper(List<List<Integer>> matrix, int dist, int x, int y) {
		if (matrix.get(x).get(y) < dist) {
			return;
		}
		if (matrix.get(x).get(y) == dist && matrix.get(x).get(y) != 1) {
			return;
		}
		matrix.get(x).set(y, dist);

		for (int i = 0; i < 4; i++) {
			int xNext = x + dx[i];
			int yNext = y + dy[i];
			if (xNext < 0 || xNext >= row || yNext < 0 || yNext >= col) {
				continue;
			}
			helper(matrix, dist + 1, xNext, yNext);
		}

	}
}
