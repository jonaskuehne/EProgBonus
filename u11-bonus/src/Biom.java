
/*
Author: J. Kuehne
Date: 07.12.2022
Lecture: EProg
Project: Bonus week 11
Summary:
    This file is part of the bonus exercise of week 11.
*/

interface Biom {
	
	public String getBiomType();
    /*
     *       "W" fuer Wasser
     *       "F" fuer Flachland
     */

	public int getFlora();
	
	public int getHeight();
	
	public boolean dryUp();
	
	// additional setters
	public void setFlora(int div);
	
	public void setHeight(int height);
}