package sudoku;

import java.util.HashSet;

public class BruteFroceAlgorithm {

	public static boolean isValidSudoku(char[][] board) {
		HashSet<String> seen = new HashSet();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int curretValue = board[i][j];
				if (curretValue != '0') {
					if (!seen.add(curretValue + "found in row" + i) || !seen.add(curretValue + "found in row" + j)
							|| !seen.add(curretValue + i / 3 + "-" + j / 3))
						return false;
				}
			}
		}
		return true;
	}

	public static char[][] GRID_TO_SOLVE = { { 9, 0, 0, 1, 0, 0, 0, 0, 5 }, { 0, 0, 5, 0, 9, 0, 2, 0, 1 },
			{ 8, 0, 0, 0, 4, 0, 0, 0, 0 }, { 0, 0, 0, 0, 8, 0, 0, 0, 0 }, { 0, 0, 0, 7, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 2, 6, 0, 0, 9 }, { 2, 0, 0, 3, 0, 0, 0, 0, 6 }, { 0, 0, 0, 2, 0, 0, 9, 0, 0 },
			{ 0, 0, 1, 9, 0, 4, 5, 7, 0 }, };

	public static void main(String[] args) {
		BruteFroceAlgorithm bfa = new BruteFroceAlgorithm();
		

	}

}
