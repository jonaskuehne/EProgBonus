import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GraphExecutionTest {
	
	@Test
	public void testIsSubProgram1() {
		Node m1 = graph1(true);
		
		assertTrue(GraphExecution.isSubProgram(m1, Node.newAddNode(4)));
		assertFalse(GraphExecution.isSubProgram(m1, Node.newAddNode(100)));
	}
	
	@Test
	public void testIsSubProgram2() {
		Node m1 = graph2();
		
		Node m2 = m1.getSubnodes()[0];
		
		assertTrue(GraphExecution.isSubProgram(m1, m2));

		Node m2New = Node.newSeqNode(new Node[] {Node.newAddNode(1), Node.newAddNode(2)});
		Node m2NewSwap = Node.newSeqNode(new Node[] {Node.newAddNode(2), Node.newAddNode(1)});			
		assertTrue(GraphExecution.isSubProgram(m1, m2New));
		assertTrue(GraphExecution.isSubProgram(m1, m2NewSwap));

		
		Node m2False = Node.newSeqNode(new Node[] {Node.newAddNode(3), Node.newAddNode(1)});

		
		assertFalse(GraphExecution.isSubProgram(m2, m2False));
	}
	
	@Test
	public void testIsSubProgram3() {
		Node m1 = graph1(true);
		
		assertTrue(GraphExecution.isSubProgram(m1, m1));
		assertTrue(GraphExecution.isSubProgram(m1, m1.getSubnodes()[1]));
		
		assertFalse(GraphExecution.isSubProgram(m1, Node.newAddNode(100)));
	}
	
	@Test
	public void testIsSubProgram4() {
		Node m1 = graph1(true);
		
		Node m5True = Node.newSeqNode(new Node[] {Node.newAddNode(3), Node.newAddNode(4)});		
		assertTrue(GraphExecution.isSubProgram(m1, m5True));
		
		Node m5False = Node.newSeqNode(new Node[] {Node.newAddNode(3), Node.newAddNode(10)});
		assertFalse(GraphExecution.isSubProgram(m1, m5False));
	}

	
	/** example graphs **/	
	public Node graph1(boolean determ) {
		Node m2 = Node.newAddNode(1);
				
		Node m7 = Node.newAddNode(4);
		Node m8 = Node.newAddNode(3);
		Node m5 = Node.newSeqNode(new Node[] {m7,m8});
		
		Node m6 = Node.newAddNode(-2);
		Node m3 = determ ? Node.newSeqNode(new Node[] {m5,m6}) : Node.newChoiceNode(new Node[] {m5,m6});
		
		Node m4 = Node.newAddNode(5);
		
		Node m1 = Node.newSeqNode(new Node[] {m2,m3,m4});
		
		return m1;		
	}
	
	public Node graph2() {
		Node m3 = Node.newAddNode(1);
		Node m4 = Node.newAddNode(2);
		
		Node m2 = Node.newSeqNode(new Node[] {m3,m4});
		
		Node m1 = Node.newSeqNode(new Node[] {m2});
		
		return m1;
	}

}
