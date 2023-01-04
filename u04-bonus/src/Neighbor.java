/*
Author: J. Kuehne
Date: 20.10.2022
Lecture: EProg
Project: Bonus week 4
Summary:
    This file searches the three (numerically) nearest neighbors of a key in an array.
*/

public class Neighbor {

	public static void main(String[] args) {
		
		int[] test1 = new int[] {1, 4, 5, 7, 9, 10};
		int[] result1 = neighbor(test1, 5);
		if (result1 != null && result1.length == 3 && result1[0] == 5 && result1[1] == 4 && result1[2] == 7) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		
		int[] test2 = new int[] {1, 4, 5, 6, 9, 10};
		int[] result2 = neighbor(test2, 5);
		if (result2 != null && result2.length == 3 && result2[0] == 5 && ((result2[1] == 4 && result2[2] == 6) || (result2[1] == 6 && result2[2] == 4))) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		
		int[] test3 = new int[] {1, 4, 5, 6, 9, 10};
		int[] result3 = neighbor(test3, 10);
		if (result3 != null && result3.length == 3 && result3[0] == 10 && result3[1] == 9 && result3[2] == 6) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		
	}
	
	public static int[] neighbor(int[] sequence, int key) {
		// return value
		int[] res = new int[3];
		
		// get theoretical location
		int index = 0;
		// iterate through input sequence
		for (;index < sequence.length; ++index) {
			// found
			if (sequence[index] >= key) {
				break;
			}
		}
		
		// pointers
		int pointerRight = index;
		// case smallest element key
		if (pointerRight == 0) {
			++pointerRight;
		}
		// left pointer one to the right of right pointer
		int pointerLeft = pointerRight - 1;
		
		// iterate through result array
		for (int count = 0; count < res.length; ++count) {
			// short circuit abusing
			// right element nearer to key -> store and adjust pointer (also if left pointer out of array)
			if (pointerLeft < 0 || (pointerRight < sequence.length && 
					(Math.abs(key - sequence[pointerRight]) < Math.abs(key - sequence[pointerLeft])))) {
				res[count] = sequence[pointerRight];
				++pointerRight;
			// left element nearer to key -> store and adjust pointer (also if right pointer out of array)
			} else {
				res[count] = sequence[pointerLeft];
				--pointerLeft;
			}
		}
		
		return res;
	}

}
