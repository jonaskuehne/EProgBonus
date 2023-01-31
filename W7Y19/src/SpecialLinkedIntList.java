
/**
 * A singly-linked list of integer values with fast addFirst and addLast methods
 */
public class SpecialLinkedIntList {
    
    SpecialIntNode first;
    SpecialIntNode last;
    
    /**
     * Appends 'value' at the end of the list.
     */
    void addLast(int value) {
    	
    	// Aendern Sie diese Methode nicht.
    
        SpecialIntNode newNode = new SpecialIntNode(value);
        if(first == null) {
        	first = newNode;
        } else {
        	last.next = newNode;
        }
        last = newNode;
    }
    
    /**
     * Appends node at the end of the list.
     */
    void addLast(SpecialIntNode newNode) {
    	
        if(first == null) {
        	first = newNode;
        } else {
        	last.next = newNode;
        }
        last = newNode;
    }
    
    SpecialLinkedIntList split(int zahl) {
    	
    	// list to store elements which are kept
    	SpecialLinkedIntList kept = new SpecialLinkedIntList();
    	// list to store elements which are removed
    	SpecialLinkedIntList removed = new SpecialLinkedIntList();
    	
    	// go through old list
    	SpecialIntNode node = first;
    	// keep track where last inserted
    	int lastInserted = 0;
    	while (node != null) {
    		
    		// new node
    		SpecialIntNode newNode = new SpecialIntNode(node.value);
    		
    		// inserted into "removed"
    		if (lastInserted == 1) {
    			// set "old" reference
    			removed.last.oldNext = newNode;
    		// inserted into "kept"
    		} else if (lastInserted == 2) {
    			// set "old" reference
    			kept.last.oldNext = newNode;
    		}
    		
    		// list to be returned
    		if (node.value > zahl) {
    			removed.addLast(newNode);
    			// mark
    			lastInserted = 1;
    		// new this
    		} else {
    			kept.addLast(newNode);
    			// mark
    			lastInserted = 2;
    		}
    		
    		// next
    		node = node.next;
    	}
    	
    	// set this to "kept"
    	this.first = kept.first;
    	this.last = kept.last;
    	
    	return removed;
    }
    
    /** Printet die Liste wenn man den 'next' Feldern folgt. */
    void printList() {
    	
    	// Sie koennen diese Methode beliebig aendern.
    	
    	SpecialIntNode n = first;
    	System.out.print("[");
    	if (n != null) {
    		System.out.print(n.value);
    		n = n.next;
    		while(n != null) {
    			System.out.print(", " + n.value);
    			n = n.next;
    		}
    	}
    	System.out.print("]");
    	System.out.println();
    }
    
    /** Printet die Liste wenn man den 'oldNext' Feldern folgt. */
    void printOldList() {
    	
    	// Sie koennen diese Methode beliebig aendern.
    	
    	SpecialIntNode n = first;
    	System.out.print("[");
    	if (n != null) {
    		System.out.print(n.value);
    		n = n.oldNext;
    		while(n != null) {
    			System.out.print(", " + n.value);
    			n = n.oldNext;
    		}
    	}
    	System.out.print("]");
    	System.out.println();
    }
    
}
