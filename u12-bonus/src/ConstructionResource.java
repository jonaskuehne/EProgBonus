
/*
Author: J. Kuehne
Date: 14.12.2022
Lecture: EProg
Project: Exercise 12 Bonus
Summary:
    This file implements a resource (what a powermove to have an interface for a single class)
*/

public class ConstructionResource implements Resource {
	// class variables
	private int typeID;
	
	// ctor
	public ConstructionResource(int typeID) {
		this.typeID = typeID;
	}

	@Override
	// get type
	public int type() {
		return typeID;
	}

}
