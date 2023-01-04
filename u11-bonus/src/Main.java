
/*
Author: J. Kuehne
Date: 07.12.2022
Lecture: EProg
Project: Bonus week 11
Summary:
    This file is part of the bonus exercise of week 11.
*/

public class Main {
	
	public static void main(String[] args) {
		// Sie koennen die main Methode beliebig aendern.

        String [][] input = {
        		{"W","F","W","W"},
        		{"F","F","F","F"},
        		{"W","W","W","W"},
        		{"F","F","W","W"}
        };

		World w = new World(input);
		
		System.out.println(w.toString());
		
		w.stepDryUp();
		
		System.out.println(w.toString());
		
		w.stepDryUp();
		
		System.out.println(w.toString());
		
		w.stepDryUp();
		
		System.out.println(w.toString());
		
		w.stepDistribute(1);
		
		System.out.println(w.toString());
	}

}
