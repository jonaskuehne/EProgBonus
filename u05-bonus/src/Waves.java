/*
Author: J. Kuehne
Date: 26.10.2022
Lecture: EProg
Project: Bonus week 5
Summary:
    This file counts the number of "waves" in a two-dimensional array.
*/

public class Waves {
	
	// returns number of waves in array
	public static int waves(int[][] matrix) {
		
		/* condition wave over whole start possibilities -> no others wave possible, ex:
		 * 1 1 1 1
		 * 1 0 0 0
		 * 1 0 0 0
		 * 1 0 0 0
		 */
		if (edgeWave(matrix)) {
			return 1;
		}
		
		// counter
		int waveCount = 0;
		
		// check possible starts -> isWave returns 0 / 1
		for (int pos = 0; pos < matrix.length; ++pos) {
			// top left corner -> only one on start
			if (pos == 0) {
				waveCount += isWave(matrix, 0, 0, 0, 0);
			// other cases -> start from row and from column
			} else {
				// start in col, check if no duplicate
				if (matrix[pos][0] != matrix[pos - 1][0]) {
					waveCount += isWave(matrix, pos, 0, pos, 0);
				}
				// start in row, check if no duplicate
				if (matrix[0][pos] != matrix[0][pos - 1]) {
					waveCount += isWave(matrix, 0, pos, 0, pos);
				}
			}
		}
		
		// result
		return waveCount;
	}
	
	// checks if array contains edge-wave (see definition above)
	public static Boolean edgeWave(int[][] matrix) {
		// get first value
		int start = matrix[0][0];
		
		// go through first row / column, not same value as start or not larger than neighbor -> no edge-wave
		for (int i = 1; i < matrix.length; ++i) {
			// row
			if (matrix[i][0] != start || matrix[i][0] <= matrix[i][1]) {
				return false;
			}
			// col
			if (matrix[0][i] != start || matrix[0][i] <= matrix[1][i]) {
				return false;
			}
			
		}
		
		// is edge-wave
		return true;
	}
	
	// checks if wave from this start is possible -> recursive boy 
	public static int isWave(int[][] matrix, int row, int col, int lastRow, int lastCol) {
		// wave not possible / stops as neighbor condition violated
		if (!neighborCheck(matrix, row, col)) {
			return 0;
		}
		
		// wave at end -> base case of recursion, also check if really end here
		if ((row == matrix.length - 1 || col == matrix.length - 1) && reallyEnd(matrix, row, col)) {
			return 1;
		}
		
		// check if there is a unique next move, make sure it's not reverse direction
		int nextRow = 0;
		int nextCol = 0;
		int numPossWaves = 0;
		
		// down
		if (row - 1 != lastRow && legalMove(matrix, row, col, row - 1, col)) {
			nextRow = row - 1;
			nextCol = col;
			++numPossWaves;
		}
		
		// left
		if (col - 1 != lastCol && legalMove(matrix, row, col, row, col - 1)) {
			nextRow = row;
			nextCol = col - 1;
			++numPossWaves;
		}
		
		// up
		if (row + 1 != lastRow && legalMove(matrix, row, col, row + 1, col)) {
			nextRow = row + 1;
			nextCol = col;
			++numPossWaves;
		}
		
		// right
		if (col + 1 != lastCol && legalMove(matrix, row, col, row, col + 1)) {
			nextRow = row;
			nextCol = col + 1;
			++numPossWaves;
		}
		
		// no or non-unique next move -> wave conditions violated
		if (numPossWaves == 0 || numPossWaves > 1) {
			return 0;
		}
		
		// wave conditions still satisfied -> next step
		return isWave(matrix, nextRow, nextCol, row, col);
	}
	
	
	// check if wave really finished -> only 2 legal moves allowed (next and last)
	public static Boolean reallyEnd(int[][] matrix, int row, int col) {
		int count = 0;
		
		// down
		if (legalMove(matrix, row, col, row - 1, col)) {
			++count;
		}
		
		// left
		if (legalMove(matrix, row, col, row, col - 1)) {
			++count;
		}
		
		// up
		if (legalMove(matrix, row, col, row + 1, col)) {
			++count;
		}
		
		// right
		if (legalMove(matrix, row, col, row, col + 1)) {
			++count;
		}
		
		// res
		return count < 2;
	}
	
	// check if neighbor-condition is satisfied
	public static Boolean neighborCheck(int[][] matrix, int row, int col) {
		// larger than rest ?
		if (noNeighbor(matrix, row, col, row - 1, col) || noNeighbor(matrix, row, col, row, col - 1) || 
				noNeighbor(matrix, row, col, row + 1, col) || noNeighbor(matrix, row, col, row, col + 1)) {
			return false;
		}
		
		// all satisfied
		return true;
	}
	
	// checks if two entries are no neighbors
	public static Boolean noNeighbor(int[][] matrix, int row, int col, int compRow, int compCol) {
		// try / catch to prevent index-pain
		try {
			// condition violated -> no neighbor
			if (matrix[row][col] < matrix[compRow][compCol]) {
				return true;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// do nothing, entry doesn't exist
		}
		// all good -> neighbor
		return false;
	}
	
	// checks if next move legal
	public static Boolean legalMove(int[][] matrix, int row, int col, int nextRow, int nextCol) {
		// try / catch to prevent index-pain
		try {
			// still same number -> legal
			if (matrix[row][col] == matrix[nextRow][nextCol]) {
				return true;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// do nothing, entry doesn't exist
		}
		// move illegal
		return false;
	}
	
}
