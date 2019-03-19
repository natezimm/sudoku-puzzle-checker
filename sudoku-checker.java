package com.nathan;

public class Main {
	public static int[][] sudoku =
					{{1, 8, 4, 9, 6, 3, 7, 2, 5},
					{5, 6, 2, 7, 4, 8, 3, 1, 9},
					{3, 9, 7, 5, 1, 2, 8, 6, 4},
					{2, 3, 9, 6, 5, 7, 1, 4, 8},
					{7, 5, 6, 1, 8, 4, 2, 9, 3},
					{4, 1, 8, 2, 3, 9, 6, 5, 7},
					{9, 4, 1, 3, 7, 6, 5, 8, 2},
					{6, 2, 3, 8, 9, 5, 4, 7, 1},
					{8, 7, 5, 4, 2, 1, 9, 3, 6}};

	public static void printSudoku(int[][] array){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				System.out.print(sudoku[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean rowChecker(int row, int num) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[row][i] == num) {
				return true;
			}
		}
		System.out.print("This sudoku array is not a valid solution.");
		System.out.println();
		System.out.print("Row " + (row + 1) + " does not contain " + num + " ");
		System.out.println();
		return false;
	}

	public static boolean colChecker(int col, int num) {
		for (int j = 0; j < 9; j++) {
			if (sudoku[j][col] == num) {
				return true;
			}
		}
		System.out.print("Column " + (col + 1) + " does not contain " + num + " ");
		System.out.println();
		return false;
	}

	public static boolean boxChecker(int row, int col, int num) {
		int boxRow = row - (row % 3);
		int boxCol = col - (col % 3);
		for (int i = boxRow; i < boxRow + 3; i++) {
			for (int j = boxCol; j < boxCol + 3; j++) {
				if (sudoku[i][j] == num) {
					return true;
				}
			}
		}
		System.out.print("3x3 box starting with " + sudoku[boxRow][boxCol] + " " + sudoku[boxRow][boxCol + 1] + " " + sudoku[boxRow][boxCol + 2] + " at top does not contain " + num);
		System.out.println();
		return false;
	}

	public static void main(String[] args) {
		System.out.print("Here is your sudoku puzzle. Any errors will be printed below puzzle. If no errors, then your solution is valid. :)");
		System.out.println();

		printSudoku(sudoku);

		for(int i = 0; i < 9; i++){
			for(int j = 1; j <=9; j++){
				rowChecker(i,j);
			}
		}

		for(int i = 0; i < 9; i++){
			for(int j = 1; j <= 9; j++){
				colChecker(i,j);
			}
		}

		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				for(int k = 1; k <= 9; k++){
					boxChecker(i,j,k);
				}
			}
		}
	}
}
