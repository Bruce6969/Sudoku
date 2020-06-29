package sudoku;

public class Sudoku {

	int[][] board;
	int size = 9;
	int empty = 0;

	public Sudoku(int[][] board) {
		this.board = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.board[i][j] = board[i][j];
			}
		}
	}

	private boolean inRowCheck(int row, int number) {
		for (int i = 0; i < size; i++)
			if (board[row][i] == number)
				return true;
		return false;
	}

	private boolean inCollumCheck(int collum, int number) {
		for (int i = 0; i < size; i++)
			if (board[collum][i] == number)
				return true;
		return false;
	}

	private boolean inBoxCheck(int row, int collum, int number) {

		int rowCheck = row - row % 3;
		int collumCheck = collum - collum % 3;

		for (int i = rowCheck; i < rowCheck + 3; i++)
			for (int j = collumCheck; j < collumCheck + 3; j++)
				if (board[i][j] == number)
					return true;
		return false;

	}

	private boolean isOk(int row, int collum, int number) {
		return !inRowCheck(row, number) && !inCollumCheck(collum, number) && !inBoxCheck(row, collum, number);
	}

	public boolean algorithmValidation() {
		for (int row = 0; row < size; row++) {
			for (int collum = 0; collum < size; collum++) {
				if (board[row][collum] == empty) {
					for (int number = 1; number <= size; number++) {
						if (isOk(row, collum, number)) {
							board[row][collum] = number;
							if (algorithmValidation()) {
								return true;
							} else {
								board[row][collum] = empty;
							}
						}
					}

					return false;
				}
			}
		}

		return true;
	}

	public void display() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(" " + board[i][j]);
			}

			System.out.println();
		}

		System.out.println();
	}

	public static int[][] GRID_TO_SOLVE = { { 9, 0, 0, 1, 0, 0, 0, 0, 5 }, { 0, 0, 5, 0, 9, 0, 2, 0, 1 },
			{ 8, 0, 0, 0, 4, 0, 0, 0, 0 }, { 0, 0, 0, 0, 8, 0, 0, 0, 0 }, { 0, 0, 0, 7, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 2, 6, 0, 0, 9 }, { 2, 0, 0, 3, 0, 0, 0, 0, 6 }, { 0, 0, 0, 2, 0, 0, 9, 0, 0 },
			{ 0, 0, 1, 9, 0, 4, 5, 7, 0 }, };

	public static void main(String[] args) {

		Sudoku sudoku = new Sudoku(GRID_TO_SOLVE);
		System.out.println("grid to solve");
		sudoku.display();

		if (sudoku.algorithmValidation()) {
			System.out.println("grid solved with bt");
			sudoku.display();
		}
		System.err.println(sudoku.algorithmValidation());
	}

}
