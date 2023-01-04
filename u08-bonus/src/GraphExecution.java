import java.util.LinkedList;

/*
Author: J. Kuehne
Date: 16.11.2022
Lecture: EProg
Project: Bonus week 8
Summary:
    This file implements the execution of a graph.
*/

public class GraphExecution {
	
	// result method
	public static LinkedProgramStateList allResults(Node n, ProgramState initState) {
		// real list, use built in utility (I don't trust you...)
		LinkedList<ProgramState> list = new LinkedList<ProgramState>();
		// add initial state
		list.add(initState);
		
		// get all program states
		recGraph(n, list);
		
		// copy stuff
		LinkedProgramStateList resList = new LinkedProgramStateList();
		for (ProgramState state : list) {
			resList.addLast(state);
		}
		return resList;
	}
	
	// does actual work
	public static void recGraph(Node n, LinkedList<ProgramState> list) {
		// case null
		if (n == null) {
			return;
		}
		// check type of node
		// addition node, base case
		if (n.getType() == "ADD") {
			// add to each
			for (ProgramState state : list) {
				// change attributes
				state.setCounter(state.getCounter() + 1);
				state.setSum(state.getSum() + n.getValue());
			}
			// finished
			return;
		// sequential node, recursive case 1
		} else if (n.getType() == "SEQ"){
			// get sub nodes
			Node[] subs = n.getSubnodes();
			// execute for each sub, just go to next one
			for (int nodeCount = 0; nodeCount < subs.length; ++nodeCount) {
				recGraph(subs[nodeCount], list);
			}
		// choice node
		} else {
			// save copy for later copying
			LinkedList<ProgramState> tempList = cloneList(list);
			// get sub nodes
			Node[] subs = n.getSubnodes();
			// execute for each sub
			for (int nodeCount = 0; nodeCount < subs.length; ++nodeCount) {
				// first one -> use original list
				if (nodeCount == 0) {
					recGraph(subs[nodeCount], list);
				// after first one
				} else {
					// new list
					LinkedList<ProgramState> choiceList;
					// new copy if not last one
					if (nodeCount < subs.length - 1) {
						// very nice function, all new -> doesn't mess with references
						choiceList = cloneList(tempList);
					// without copy for last one (recycling)
					} else {
						choiceList = tempList;
					}
					// execute
					recGraph(subs[nodeCount], choiceList);
					// feed back into original list afterwards
					for (ProgramState state : choiceList) {
						list.add(state);
					}
				}
			}
		}
	}
	
	// clones list
	public static LinkedList<ProgramState> cloneList(LinkedList<ProgramState> list) {
		// new instance
		LinkedList<ProgramState> resList = new LinkedList<ProgramState>();
		// fill
		for (ProgramState state : list) {
			// copy of attribute -> new object
			resList.add(state.clone());
		}
		return resList;
	}

}
