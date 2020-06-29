package sudoku;

public class NewTest {
	int[][] board;
	int size = 9;
	int empty = 0;

	public NewTest(int[][] board) {
		this.board = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.board[i][j] = board[i][j];
			}
		}
	}

	private boolean inRowCheck(int row, int collumn, int number) {
		for (int i = 0; i < size; i++) {
			int comparison = board[row][i];
			if (comparison != empty && collumn != i && comparison == number) {
				return true;
			}
		}
		return false;
	}

	private boolean inCollumCheck(int row, int collum, int number) {
		for (int i = 0; i < size; i++) {
			int comparison = board[i][collum];
			if (comparison != empty && i != row && comparison == number) {
				return true;
			}
		}
		return false;
	}

	private boolean inBoxCheck(int row, int collum, int number) {

		int rowCheck = row - row % 3;
		int collumCheck = collum - collum % 3;

		for (int i = rowCheck; i < rowCheck + 3; i++) {
			for (int j = collumCheck; j < collumCheck + 3; j++) {
				int comparison = board[i][j];
				if (comparison != empty && i != row && j != collum && comparison == number)
					return true;
			}
		}
		return false;

	}

	private boolean isOk(int row, int collum, int number) {
		boolean inRowCheck = inRowCheck(row, collum, number);
		boolean inColumnCheck = inCollumCheck(row, collum, number);
		boolean inBoxCheck = inBoxCheck(row, collum, number);
		boolean check = !inRowCheck && !inColumnCheck && !inBoxCheck;
		System.out
				.println("Row : " + row + " Collumn : " + collum + " Number : " + number + " " + check + " " + inRowCheck + " " + inColumnCheck + " " + inBoxCheck);
		return check;
	}

	public boolean algorithmValidation() {
		for (int row = 0; row < size; row++) {
			for (int collum = 0; collum < size; collum++) {
				int number = board[row][collum];
				if (!isOk(row, collum, number)) {
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

		NewTest sudoku = new NewTest(GRID_TO_SOLVE);
		System.out.println("grid to solve");
		sudoku.display();

		boolean isValid = sudoku.algorithmValidation();
		if (isValid) {
			System.out.println("grid solved with bt");
			sudoku.display();
		}
	}

}