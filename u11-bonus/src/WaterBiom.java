
/*
Author: J. Kuehne
Date: 07.12.2022
Lecture: EProg
Project: Bonus week 11
Summary:
    This file is part of the bonus exercise of week 11.
*/

public class WaterBiom implements Biom {
	// class attributes
	int diversity;
	
	// ctor
	public WaterBiom(int diversity) {
		this.diversity = diversity;
	}
	
	// getters
	
	@Override
	public String getBiomType() {
		return "W";
	}
	
	@Override
	public int getFlora() {
		return diversity;
	}
	
	@Override
	public int getHeight() {
		return 0;
	}
	
	@Override
	// dry up utility
	public boolean dryUp() {
		// new value
		diversity = Math.max(diversity - 5, 0);
		return false;
	}
	
	// setters
	
	@Override
	public void setFlora(int div) {
		diversity = div;
	}
	
	@Override
	public void setHeight(int height) {}
}
