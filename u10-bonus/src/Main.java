
public class Main {
	
	public static void main(String[] args) {
		// Sie koennen die main Methode beliebig aendern.
		
		Node r3 = Node.newAddNode(1);
		Node r4 = Node.newAddNode(2);
		
		Node r2 = Node.newSeqNode(new Node[] {r3,r4});
		
		Node r1 = Node.newSeqNode(new Node[] {r2});
			
		Node r2New = Node.newSeqNode(new Node[] {Node.newAddNode(1), Node.newAddNode(2)});
		Node r2NewSwap = Node.newSeqNode(new Node[] {Node.newAddNode(2), Node.newAddNode(1)});			
		System.out.println(GraphExecution.isSubProgram(r1, r2New));
		System.out.println(GraphExecution.isSubProgram(r1, r2NewSwap));
		
		Node r2False = Node.newSeqNode(new Node[] {Node.newAddNode(3), Node.newAddNode(1)});
		System.out.println(GraphExecution.isSubProgram(r1, r2False));

	}
}
