import java.util.LinkedList;
import java.util.Arrays;

/*
Author: J. Kuehne
Date: 30.11.2022
Lecture: EProg
Project: Bonus week 10
Summary:
    This file determines if a node is a subprogram(nasty definition) of another node.
*/

public class GraphExecution {
	
	// actual method
	static boolean isSubProgram(Node n1, Node n2) {
		// check type
		// add node -> nice
		// true if called on same node I guess
		if (n2.getType() == "ADD") {
			return isSubAdd(n1, n2.getValue());
		// other one
		} else {
			return isSubSeq(n1, n2.getSubnodes());
		}
	}
	
	// case ADD-node
	static boolean isSubAdd(Node n, int v) {
		// type
		// kinda base case
		if (n.getType() == "ADD") {
			// is right one
			if (n.getValue() == v) {
				return true;
			// not right one
			} else {
				return false;
			}
		// is seq -> go further
		} else {
			// get sub nodes
			Node[] sub = n.getSubnodes();
			// go over subs
			for (int i = 0; i < sub.length; ++i) {
				// is there something?
				if (isSubAdd(sub[i], v)) {
					// yes
					return true;
				}
			}
			// nothing found
			return false;
		}
	}
	
	// case SEQ-node
	static boolean isSubSeq(Node n, Node[] res) {
		// type
		// add not relevant -> false
		if (n.getType() == "ADD") {
			return false;
		// in SEQ we trust
		} else {
			// get subs
			Node[] sub = n.getSubnodes();
			// right one?
			if (isPerm(sub, res)) {
				// yes
				return true;
			}
			// nah, sad story
			for (int i = 0; i < sub.length; ++i) {
				// try next one
				if (isSubSeq(sub[i], res)) {
					// yes
					return true;
				}
			}
		}
		// nothing found
		return false;
	}
	
	// checks if arrays of nodes are permutations
	static boolean isPerm(Node[] n, Node[] m) {
		// wrong dimension
		if (n.length != m.length) {
			return false;
		}
		// convert second one into list -> prevent duplicates (coward move I know...)
		// very convenient syntax, no more java hate from my side
		LinkedList<Node> list = new LinkedList<Node>(Arrays.asList(m));
		// check if match for each element in n
		for (int i = 0; i < n.length; ++i) {
			// memorize if found
			boolean found = false;
			// store to remove afterwards
			Node tempNode = null;
			// try all elements in m
			for (Node lNode : list) {
				// recursive call to check equality
				if (isSubProgram(n[i], lNode)) {
					// found
					found = true;
					// store
					tempNode = lNode;
					// skip iteration -> efficiency
					continue;
				}
			}
			// not found
			if (!found) {
				// maybe next time...
				return false;
			}
			// remove from list, if not in there: not executed since return above in that case
			list.remove(tempNode);
		}
		// all good
		return true;
	}

}
