
/*
Author: J. Kuehne
Date: 07.12.2022
Lecture: EProg
Project: Bonus week 11
Summary:
    This file is part of the bonus exercise of week 11.
*/

public class World {
	
	// class attributes
    private int size;
    private Biom[][] world;
    
	@Override 
	public String toString() {
    	String str = "";
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
            	str += this.getBiom(x, y).getBiomType();
            }
            str += System.lineSeparator();
        }
        return str;
	}
	
	// ctor
    public World(String [] [] biomGrid) {
    	// get size
        size = biomGrid.length;
        // array for biom-objects
        world = new Biom[biomGrid.length][biomGrid.length];
        
        // check if valid input
    	if(biomGrid.length < 2) {
    		throw new IllegalArgumentException();
    	}
    	
    	// go through input
    	// row
        for (int i = 0; i < biomGrid.length; i++) {
        	// check if valid input
        	if(biomGrid[i].length != biomGrid.length) {
        		throw new IllegalArgumentException();        		
        	}
        	// column
        	for(int j = 0; j < biomGrid[i].length; j++) {
        		// get type
        		String biomRepr = biomGrid[i][j];
        		// check type
        		if(biomRepr.equals("W")) {
        			// new water element
                    world[i][j] = new WaterBiom(15);
        			
        		} else if(biomRepr.equals("F")) {
                    // new land element
        			world[i][j] = new LandBiom(12, 3);
        			
        		} else {
        			// invalid
        			throw new IllegalArgumentException();
        		}
        	}
        }
    }
    
    // returns biom object at position
    public Biom getBiom(int x, int y) {
    	try {
    		return world[x][y];
    	} catch (Exception e) {
    		return null;
    	}
    }
    
    // dries everything up :(
    public void stepDryUp() {
    	// for each element
    	// row
        for (int i = 0; i < world.length; ++i) {
        	// column
        	for (int j = 0; j < world[i].length; ++j) {
        		// do computation
        		if (world[i][j].dryUp()) {
        			// needs to change
        			world[i][j] = new WaterBiom(world[i][j].getFlora());
        		}
        	}
        }
    }
    
    // new distribution
    public void stepDistribute(int p) {
    	// store old values
    	int[][] divSum = new int[world.length][world.length];
    	int[][] heightSum = new int[world.length][world.length];
    	
    	// get values
    	getValues(p, divSum, heightSum);
    	
    	// adjust values
    	// row
    	for (int i = 0; i < world.length; ++i) {
    		// column
    		for (int j = 0; j < world[i].length; ++j) {
    			// set values
    			world[i][j].setFlora(divSum[i][j]);
    			world[i][j].setHeight(world[i][j].getHeight() + heightSum[i][j]);
    		}
    	}
    }
    
    // gets values for new distribution
    public void getValues(int p, int[][] divSum, int[][] heightSum) {
    	// compute for each element
    	// row
    	for (int row = 0; row < world.length; ++row) {
    		// column
    		for (int col = 0; col < world[row].length; ++col) {
    			// now additional stuff
    			// p
    			for (int pAdd = 1; pAdd <= p; ++pAdd) {
    				// exceptions for convenience
    				// up
    				try {
    					compute(row, col, row - pAdd, col, divSum, heightSum);
    				} catch(Exception e) {
    					// do nothing
    				}
    				// down
    				try {
    					compute(row, col, row + pAdd, col, divSum, heightSum);
    				} catch(Exception e) {
    					// do nothing
    				}
    				// left
    				try {
    					compute(row, col, row, col - pAdd, divSum, heightSum);
    				} catch(Exception e) {
    					// do nothing
    				}
    				// right
    				try {
    					compute(row, col, row, col + pAdd, divSum, heightSum);
    				} catch(Exception e) {
    					// do nothing
    				}
    			}
    			
    		}
    	}
    }
    
    // does effective computation and generates (unchecked) exception if necessary
    public void compute(int row, int col, int newRow, int newCol, int[][] divSum, int[][] heightSum) {
    	divSum[row][col] += world[newRow][newCol].getFlora();
    	if (world[newRow][newCol].getBiomType().equals("F")) {
    		++heightSum[row][col];
    	}
    }
    
    
    
}

