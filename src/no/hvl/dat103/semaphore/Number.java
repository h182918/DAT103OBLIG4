package no.hvl.dat103.semaphore;

public class Number{
	int counter;
	
	public Number() {
		this.counter = 0;
	}
	
	public int increase() {
		counter++;
		return counter;
	}
	
	public int decrease() {
		counter--;
		return counter;
	}
	
	public int getNumber() {
		return counter;
	}
}
