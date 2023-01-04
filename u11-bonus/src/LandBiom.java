
/*
Author: J. Kuehne
Date: 07.12.2022
Lecture: EProg
Project: Bonus week 11
Summary:
    This file is part of the bonus exercise of week 11.
*/

public class LandBiom implements Biom {
	// class attributes
	int diversity;
	int height;
	
	// ctor
	public LandBiom(int diversity, int height) {
		this.diversity = diversity;
		this.height = height;
	}
	
	// getters
	
	@Override
	public String getBiomType() {
		return "F";
	}
	
	@Override
	public int getFlora() {
		return diversity;
	}
	
	@Override
	public int getHeight() {
		return height;
	}
	
	@Override
	// dry up utility, returns true if conversion needed
	public boolean dryUp() {
		// new values
		diversity = Math.max(diversity - 3, 0);
		--height;
		// change?
		if (height > 0) {
			// no
			return false;
		} else {
			// yes
			return true;
		}
	}
	
	// setters
	
	@Override
	public void setFlora(int div) {
		diversity = div;
	}
	
	@Override
	public void setHeight(int height) {
		this.height = height;
	}
}
