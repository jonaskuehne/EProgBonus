/*
Author: J. Kuehne
Date: 02.11.2022
Lecture: EProg
Project: Bonus week 6
Summary:
    This file contains the tests for the bonus exercise of week 6.
*/

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class PrefixConstructionTest {


	@Test
	public void test1() {
		assertTrue(PrefixConstruction.isPrefixConstruction("aaa", "a", 4));
		assertFalse(PrefixConstruction.isPrefixConstruction("aaa", "a", 2));
		assertTrue(PrefixConstruction.isPrefixConstruction("aaaaaaa", "aaa", 3));
		
		assertTrue(PrefixConstruction.isPrefixConstruction("abcababc", "abc", 4));
		assertFalse(PrefixConstruction.isPrefixConstruction("abcbcabc", "abc", 4));
		assertTrue(PrefixConstruction.isPrefixConstruction("abab", "abac", 2));
	}
	
	@Test
	public void test2() {
		assertTrue(PrefixConstruction.isPrefixConstruction("", "a", 10));
		assertFalse(PrefixConstruction.isPrefixConstruction(null, "a", 2));
		assertFalse(PrefixConstruction.isPrefixConstruction("a", "", 10));
		assertTrue(PrefixConstruction.isPrefixConstruction("", "", 10));
		assertFalse(PrefixConstruction.isPrefixConstruction("a", "a", 0));
		assertFalse(PrefixConstruction.isPrefixConstruction("", "", 0));
	}
	
}
