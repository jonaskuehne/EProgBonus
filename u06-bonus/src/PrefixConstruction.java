/*
Author: J. Kuehne
Date: 02.11.2022
Lecture: EProg
Project: Bonus week 6
Summary:
    This file checks if a string can be built of a number of prefixes of another string.
*/

public class PrefixConstruction {
	
	// returns if prefix construction possible
	public static boolean isPrefixConstruction(String s, String t, int n) {
		// check if not empty or null
		if (s == null || t == null || n == 0) {
			return false;
		}
		
		// get prefixes
		String[] prefix = findPrefix(t);
		// start
		String start = "";
		
		// res
		return isConstruction(s, prefix, start, n);
	}
	
	// does actual work, recursive
	public static boolean isConstruction(String goal, String[] prefixes, String current, int n) {
		// base cases
		// found
		if (goal.equals(current)) {
			return true;
		}
		// too many tries -> no combination
		if (n == 0) {
			return false;
		}
		
		// recursive case
		for (int i = 0; i < prefixes.length; ++i) {
			// prevent unnecessary recursive calls
			if (goal.startsWith(current)) {
				// recursive call
				if (isConstruction(goal, prefixes, current + prefixes[i], n - 1)) {
					return true;
				}
			}
		}
		
		// nothing found
		return false;
	}
	
	// returns array with all possible prefixes of string input
	public static String[] findPrefix(String s) {
		// res -> all prefixes
		String[] res = new String[s.length()];
		// get prefixes
		for (int i = 0; i < s.length(); ++i) {
			res[i] = s.substring(0, i + 1);
		}
		return res;
	}
}
