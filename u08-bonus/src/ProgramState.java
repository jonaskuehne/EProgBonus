
public class ProgramState {
	
	int sum;
	int counter;
	
	ProgramState(int sum, int counter) {		
		this.sum = sum;
		this.counter = counter;
	}

	int getSum() {
		return sum;
	}

	int getCounter() {
		return counter;
	}
	
	// added those
	void setSum(int sum) {
		this.sum = sum;
	}
	
	void setCounter(int counter) {
		this.counter = counter;
	}
	
	@Override
	public ProgramState clone() {
		return new ProgramState(sum, counter);
	}

}