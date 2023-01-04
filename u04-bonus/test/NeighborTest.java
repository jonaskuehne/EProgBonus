/*
Author: J. Kuehne
Date: 20.10.2022
Lecture: EProg
Project: Bonus week 4
Summary:
    This file contains the tests for Neighbor.
*/

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class NeighborTest {

	@Test
	public void testNeighborExamples() {
		// basic
		assertArrayEquals(new int[] {5, 4, 7}, Neighbor.neighbor(new int[] {1, 4, 5, 7, 9, 10}, 5));
		// non-unique
		int[] test2 = Neighbor.neighbor(new int[] {1, 4, 5, 6, 9, 10}, 5);
		assertTrue(test2 != null && test2.length == 3 && test2[0] == 5 && ((test2[1] == 4 && test2[2] == 6) || (test2[1] == 6 && test2[2] == 4)));
		// last element
		assertArrayEquals(new int[] {10, 9, 6}, Neighbor.neighbor(new int[] {1, 4, 5, 6, 9, 10}, 10));
		// first element
		assertArrayEquals(new int[] {1, 4, 5}, Neighbor.neighbor(new int[] {1, 4, 5, 6, 9, 10}, 1));
		// only three elements
		assertArrayEquals(new int[] {20, 23, 5}, Neighbor.neighbor(new int[] {5, 20, 23}, 20));
		
		// basic not in array
		assertArrayEquals(new int[] {6, 3, 8}, Neighbor.neighbor(new int[] {1, 3, 6, 8, 9, 10}, 5));
		// last element not in array
		assertArrayEquals(new int[] {10, 9, 6}, Neighbor.neighbor(new int[] {1, 4, 5, 6, 9, 10}, 10));
		// first element not in array
		assertArrayEquals(new int[] {1, 4, 5}, Neighbor.neighbor(new int[] {1, 4, 5, 6, 9, 10}, -20));
	}
}
